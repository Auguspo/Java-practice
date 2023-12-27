package com.biblioteca.ui;

import com.biblioteca.data.EjemplarData;
import com.biblioteca.data.LibroData;
import com.biblioteca.model.Ejemplar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EjemplarPanel extends JPanel {

    private EjemplarData ejemplarData;
    private LibroData libroData;
    private JList<String> ejemplarList;
    private DefaultListModel<String> ejemplarListModel;

    private JTextField idField;
    private JComboBox<String> estadoComboBox, libroISBNComboBox;

    public EjemplarPanel(EjemplarData ejemplarData, LibroData libroData) {
        this.ejemplarData = ejemplarData;
        this.libroData = libroData;
        

        setLayout(new BorderLayout());

        ejemplarListModel = new DefaultListModel<>();
        ejemplarList = new JList<>(ejemplarListModel);

        JScrollPane scrollPane = new JScrollPane(ejemplarList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes de 5 en todos los lados

        // Crear los JLabel y JTextField y agregarlos al panel con el diseño de cuadrícula
        agregarCampo(inputPanel, gbc, "ID:", idField = new JTextField());
        agregarCampo(inputPanel, gbc, "Estado:", estadoComboBox = new JComboBox<>(new String[]{"Disponible", "Prestado"}));
        agregarCampo(inputPanel, gbc, "Libro ISBN:", libroISBNComboBox = new JComboBox<>());

        // Obtener la lista de ISBN disponibles y cargarla en el ComboBox
        List<String> isbnDisponibles = libroData.obtenerISBNLibros();
        for (String isbn : isbnDisponibles) {
            libroISBNComboBox.addItem(isbn);
        }

        // Resto del código para los botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        JButton agregarButton = new JButton("Agregar Ejemplar");
        JButton modificarButton = new JButton("Modificar Ejemplar");
        JButton eliminarButton = new JButton("Eliminar Ejemplar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplar();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEjemplar();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEjemplar();
            }
        });

        // Añadir botones al panel con el mismo diseño de cuadrícula
        inputPanel.add(agregarButton, gbc);

        gbc.gridx = 1;
        inputPanel.add(modificarButton, gbc);

        gbc.gridx = 2;
        inputPanel.add(eliminarButton, gbc);

        // Agregar el panel de entrada al sur del panel principal
        add(inputPanel, BorderLayout.SOUTH);

        // Agregar el ListSelectionListener al JList
        ejemplarList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Cuando se selecciona un ejemplar, completa los campos
                    seleccionarEjemplar();
                }
            }
        });

        // Actualizar la lista de ejemplares
        actualizarListaEjemplares();
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String labelText, JComponent component) {
        gbc.gridx = 0;
        gbc.gridy++; // Asegurarse de que la etiqueta vaya a la siguiente fila
        JLabel label = new JLabel(labelText);
        gbc.anchor = GridBagConstraints.WEST; // Alinear la etiqueta a la izquierda
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);

        gbc.gridy++;
    }

    private void seleccionarEjemplar() {
        // Obtiene el índice del ejemplar seleccionado
        int selectedIndex = ejemplarList.getSelectedIndex();

        if (selectedIndex != -1) {
            // Obtiene el ID del ejemplar seleccionado
            int selectedID = Integer.parseInt(ejemplarList.getModel().getElementAt(selectedIndex).split(" - ")[0]);

            // Obtiene el ejemplar de la base de datos usando el ID
            Ejemplar selectedEjemplar = ejemplarData.obtenerEjemplarPorID(selectedID);

            // Rellena los campos con los datos del ejemplar seleccionado
            if (selectedEjemplar != null) {
                idField.setText(String.valueOf(selectedEjemplar.getID()));
                estadoComboBox.setSelectedItem(selectedEjemplar.getEstado());
                libroISBNComboBox.setSelectedItem(selectedEjemplar.getLibroISBN());
            }
        }
    }

    private void agregarEjemplar() {
    // Obtener el ID del campo si se proporciona, de lo contrario, será -1
    int id = idField.getText().isEmpty() ? -1 : Integer.parseInt(idField.getText());
    String estado = estadoComboBox.getSelectedItem().toString();
    String libroISBN = libroISBNComboBox.getSelectedItem().toString();

    // Crear un nuevo ejemplar, el cual manejará la generación automática del ID si es necesario
    Ejemplar nuevoEjemplar = new Ejemplar(id, libroISBN, estado);
    ejemplarData.agregarEjemplar(nuevoEjemplar);

    limpiarCamposEjemplar();
    actualizarListaEjemplares();
}


    private void modificarEjemplar() {
        int id = Integer.parseInt(idField.getText());
        String estado = estadoComboBox.getSelectedItem().toString();
        String libroISBN = libroISBNComboBox.getSelectedItem().toString();

        Ejemplar ejemplarExistente = ejemplarData.obtenerEjemplarPorID(id);

        if (ejemplarExistente != null) {
            ejemplarExistente.setEstado(estado);
            ejemplarExistente.setLibroISBN(libroISBN);

            ejemplarData.actualizarEjemplar(ejemplarExistente);

            limpiarCamposEjemplar();
            actualizarListaEjemplares();
        } else {
            JOptionPane.showMessageDialog(this, "El ejemplar con ID " + id + " no existe.");
        }
    }

 private void eliminarEjemplar() {
    int selectedIndex = ejemplarList.getSelectedIndex();

    if (selectedIndex != -1) {
        // Obtiene el ID del ejemplar seleccionado
        String selectedString = ejemplarList.getModel().getElementAt(selectedIndex);
        int ejemplarID = Integer.parseInt(selectedString.split(" - ")[0]);
System.out.println(ejemplarID);
        // Verificar si hay préstamos relacionados con el ejemplar

        ejemplarData.eliminarEjemplar(ejemplarID);

        limpiarCamposEjemplar();
        actualizarListaEjemplares();
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un ejemplar para eliminar.");
    }
}



    private void actualizarListaEjemplares() {
        ejemplarListModel.clear();
        List<Ejemplar> ejemplares = ejemplarData.obtenerTodosLosEjemplares();

        for (Ejemplar ejemplar : ejemplares) {
            ejemplarListModel.addElement(ejemplar.getID() + " - " + ejemplar.getLibroISBN() + " - " + ejemplar.getEstado());
        }
    }

    private void limpiarCamposEjemplar() {
        idField.setText("");
        estadoComboBox.setSelectedIndex(0); // Establecer el primer estado por defecto
        libroISBNComboBox.setSelectedIndex(0); // Establecer el primer ISBN por defecto
    }
}
