package com.biblioteca.ui;

import com.biblioteca.data.LectorData;
import com.biblioteca.model.Lector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LectorPanel extends JPanel {

    private LectorData lectorData;

    private JList<String> lectorList;
    private DefaultListModel<String> lectorListModel;

    private JTextField idField, nombreField, direccionField, telefonoField;

    public LectorPanel(LectorData lectorData) {
        this.lectorData = lectorData;

        setLayout(new BorderLayout());

        lectorListModel = new DefaultListModel<>();
        lectorList = new JList<>(lectorListModel);

        JScrollPane scrollPane = new JScrollPane(lectorList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes de 5 en todos los lados

        // Crear los JLabel y JTextField y agregarlos al panel con el diseño de cuadrícula
        agregarCampo(inputPanel, gbc, "DNI:", idField = new JTextField());
        agregarCampo(inputPanel, gbc, "Nombre:", nombreField = new JTextField());
        agregarCampo(inputPanel, gbc, "Dirección:", direccionField = new JTextField());
        agregarCampo(inputPanel, gbc, "Teléfono:", telefonoField = new JTextField());

        // Resto del código para los botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        JButton agregarButton = new JButton("Agregar Lector");
        JButton modificarButton = new JButton("Modificar Lector");
        JButton eliminarButton = new JButton("Eliminar Lector");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLector();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarLector();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLector();
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
        lectorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Cuando se selecciona un ejemplar, completa los campos
                    seleccionarLector();
                }
            }
        });

        // Actualizar la lista de lectores
        if (lectorData != null) {
            actualizarListaLectores();
        } else {
            System.out.println("lectorData es nulo");
        }
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField) {
        gbc.gridx = 0;
        gbc.gridy++; // Asegurarse de que la etiqueta vaya a la siguiente fila
        JLabel label = new JLabel(labelText);
        gbc.anchor = GridBagConstraints.WEST; // Alinear la etiqueta a la izquierda
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);

        gbc.gridy++;
    }

    private void seleccionarLector() {
        // Obtiene el índice del lector seleccionado
        int selectedIndex = lectorList.getSelectedIndex();

        if (selectedIndex != -1) {
            // Obtiene el DNI del lector seleccionado
            String selectedDNI = lectorList.getModel().getElementAt(selectedIndex).split(" - ")[0];

            // Obtiene el lector de la base de datos usando el DNI
            Lector selectedLector = lectorData.obtenerLectorPorDNI(selectedDNI);

            // Rellena los campos con los datos del lector seleccionado
            if (selectedLector != null) {
                idField.setText(selectedLector.getDNI());
                nombreField.setText(selectedLector.getNombre());
                direccionField.setText(selectedLector.getDomicilio());
                telefonoField.setText(selectedLector.getTelefono());
            }
        }
    }

    private void agregarLector() {
        String DNI = idField.getText();
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();

        Lector nuevoLector = new Lector(DNI, nombre, direccion, telefono, true);
        lectorData.agregarLector(nuevoLector);

        limpiarCamposLector();
        actualizarListaLectores();
    }

    private void modificarLector() {
        String DNI = idField.getText();
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();

        Lector lectorExistente = lectorData.obtenerLectorPorDNI(DNI);

        if (lectorExistente != null) {
            lectorExistente.setNombre(nombre);
            lectorExistente.setDomicilio(direccion);
            lectorExistente.setTelefono(telefono);

            lectorData.actualizarLector(lectorExistente);

            limpiarCamposLector();
            actualizarListaLectores();
        } else {
            JOptionPane.showMessageDialog(this, "El lector con DNI " + DNI + " no existe.");
        }
    }

    private void eliminarLector() {
        String lectorDNI = idField.getText();

        lectorData.eliminarLector(lectorDNI);

        limpiarCamposLector();
        actualizarListaLectores();
    }

private void actualizarListaLectores() {
    lectorListModel.clear();
    List<Lector> lectores = lectorData.obtenerTodosLosLectores();

    for (Lector lector : lectores) {
        lectorListModel.addElement(lector.toString());
    }
}




    private void limpiarCamposLector() {
        idField.setText("");
        nombreField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
    }
}
