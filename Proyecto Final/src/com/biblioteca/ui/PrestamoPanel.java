package com.biblioteca.ui;

import com.biblioteca.data.PrestamoData;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Lector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PrestamoPanel extends JPanel {

    private PrestamoData prestamoData;
    private List<Libro> librosDisponibles;
    private List<Lector> lectoresDisponibles;
    private JList<Prestamo> prestamoList;
    private DefaultListModel<Prestamo> prestamoListModel;
 
    private JDateChooser fechaPrestamoDatePicker;
    private JDateChooser fechaDevolucionDatePicker;
    private JComboBox<Libro> libroComboBox;
    private JComboBox<Lector> lectorComboBox;
    private JComboBox<String> estadoComboBox;  // Agregado ComboBox para el estado
    private String estadoOriginal;  // Variable para almacenar el estado original al seleccionar un préstamo

    public PrestamoPanel(PrestamoData prestamoData, List<Libro> librosDisponibles, List<Lector> lectoresDisponibles) {
        this.prestamoData = prestamoData;
        this.librosDisponibles = librosDisponibles;
        this.lectoresDisponibles = lectoresDisponibles;

        setLayout(new BorderLayout());

        prestamoListModel = new DefaultListModel<>();
        prestamoList = new JList<>(prestamoListModel);

        fechaPrestamoDatePicker = new JDateChooser();
        fechaDevolucionDatePicker = new JDateChooser();
        estadoComboBox = new JComboBox<>(new String[]{"Pendiente", "Atrasado", "Devuelto"});

        prestamoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                seleccionarPrestamo();
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, createScrollPane(), createInputPanel());
        splitPane.setResizeWeight(0.5);

        add(splitPane, BorderLayout.CENTER);

        actualizarListaPrestamos();
    }

    private JScrollPane createScrollPane() {
        JScrollPane scrollPane = new JScrollPane(prestamoList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 150));

        return scrollPane;
    }

   private JPanel createInputPanel() {
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(5, 10, 5, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridheight = 1;
    gbc.weightx = 0.5;

    libroComboBox = new JComboBox<>(librosDisponibles.toArray(new Libro[0]));
    lectorComboBox = new JComboBox<>(lectoresDisponibles.toArray(new Lector[0]));

    fechaPrestamoDatePicker = new JDateChooser();
    fechaDevolucionDatePicker = new JDateChooser();

    gbc.gridy++;

    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.EAST;
    inputPanel.add(new JLabel("Libro:"), gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    inputPanel.add(libroComboBox, gbc);
    gbc.gridy++;

    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.EAST;
    inputPanel.add(new JLabel("Lector:"), gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    inputPanel.add(lectorComboBox, gbc);
    gbc.gridy++;

    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.EAST;
    inputPanel.add(new JLabel("Estado:"), gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    inputPanel.add(estadoComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.EAST;
    inputPanel.add(new JLabel("Fecha Prestamo:"), gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    inputPanel.add(fechaPrestamoDatePicker, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.EAST;
    inputPanel.add(new JLabel("Fecha Devolucion:"), gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    inputPanel.add(fechaDevolucionDatePicker, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 3;
    gbc.insets = new Insets(10, 10, 5, 10);
    inputPanel.add(Box.createVerticalStrut(10), gbc);
    gbc.gridy++;

    gbc.anchor = GridBagConstraints.CENTER;

    // Crear un nuevo JPanel para los botones y organizarlos en dos columnas
    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 filas significa tantas filas como sea necesario

    JButton agregarButton = new JButton("Agregar Prestamo");
    JButton modificarButton = new JButton("Modificar Prestamo");
    JButton eliminarButton = new JButton("Eliminar Prestamo");

    buttonPanel.add(agregarButton);
    buttonPanel.add(modificarButton);
    buttonPanel.add(eliminarButton);
    

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 3;
    gbc.insets = new Insets(10, 10, 5, 10);
    inputPanel.add(buttonPanel, gbc);
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            agregarPrestamo();
        }
    });
    modificarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modificarPrestamo();
        }
    });

    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarPrestamo();
        }
    });



    return inputPanel;
}
    private void seleccionarPrestamo() {
        int selectedIndex = prestamoList.getSelectedIndex();

        if (selectedIndex != -1) {
            Prestamo prestamoSeleccionado = prestamoListModel.getElementAt(selectedIndex);
            estadoOriginal = prestamoSeleccionado.getEstado();

            estadoComboBox.setSelectedItem(prestamoSeleccionado.getEstado());
          
            fechaPrestamoDatePicker.setDate(prestamoSeleccionado.getFechaPrestamo());
            fechaDevolucionDatePicker.setDate(prestamoSeleccionado.getFechaDevolucion());

            for (int i = 0; i < librosDisponibles.size(); i++) {
                if (librosDisponibles.get(i).getISBN().equals(prestamoSeleccionado.getISBN())) {
                    libroComboBox.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < lectoresDisponibles.size(); i++) {
                if (lectoresDisponibles.get(i).getDNI().equals(prestamoSeleccionado.getLectorDNI())) {
                    lectorComboBox.setSelectedIndex(i);
                    break;
                }
            }
            
            
        }
    }
    private void agregarPrestamo() {
        Libro libroSeleccionado = (Libro) libroComboBox.getSelectedItem();
        Lector lectorSeleccionado = (Lector) lectorComboBox.getSelectedItem();

        if (lectorSeleccionado != null && libroSeleccionado != null) {
            String lectorDNI = lectorSeleccionado.getDNI();
            String libroISBN = libroSeleccionado.getISBN();

           
                int ejemplarID = prestamoData.obtenerEjemplarDisponible(libroISBN);

                if (ejemplarID != -1) {
                    Prestamo nuevoPrestamo = new Prestamo();
                    nuevoPrestamo.setLectorDNI(lectorDNI);
                    nuevoPrestamo.setEjemplarID(ejemplarID);
                    nuevoPrestamo.setFechaPrestamo(new Date(System.currentTimeMillis()));
                    nuevoPrestamo.setISBN(libroISBN);
                    nuevoPrestamo.setFechaDevolucion(calcularFechaDevolucion());
                    nuevoPrestamo.setEstado("Pendiente");

                    prestamoData.agregarPrestamoVerificandoLector(nuevoPrestamo);

                    limpiarCamposPrestamo();
                    actualizarListaPrestamos();
               
            } else {
                JOptionPane.showMessageDialog(this, "El lector tiene libros sin devolver. No se puede realizar un nuevo préstamo.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un lector y un libro antes de agregar un préstamo.");
        }
    }

    private Date calcularFechaDevolucion() {
        long tiempoActual = System.currentTimeMillis();
        long tiempoDevolucion = tiempoActual + (15 * 24 * 60 * 60 * 1000);  // 15 días en milisegundos

        return new Date(tiempoDevolucion);
    }



 private void modificarPrestamo() {
    Prestamo prestamoSeleccionado = prestamoList.getSelectedValue();

    if (prestamoSeleccionado != null) {
        Libro libroSeleccionado = (Libro) libroComboBox.getSelectedItem();
        Lector lectorSeleccionado = (Lector) lectorComboBox.getSelectedItem();

        if (lectorSeleccionado != null && libroSeleccionado != null) {
            String nuevoEstado = estadoComboBox.getSelectedItem().toString();
            String lectorDNI = lectorSeleccionado.getDNI();
            String libroISBN = libroSeleccionado.getISBN();

            // Obtener un ejemplar disponible para el libro seleccionado
            int ejemplarID = prestamoData.obtenerEjemplarDisponible(libroISBN);

            if (ejemplarID != -1) {
                // Modificar el préstamo existente con los nuevos datos
                Prestamo nuevoPrestamo = new Prestamo();
                nuevoPrestamo.setID(prestamoSeleccionado.getID());
                nuevoPrestamo.setLectorDNI(lectorDNI);
                nuevoPrestamo.setEjemplarID(ejemplarID);
                nuevoPrestamo.setEstado(nuevoEstado);
                nuevoPrestamo.setISBN(libroISBN);
                nuevoPrestamo.setFechaPrestamo(prestamoSeleccionado.getFechaPrestamo());
                nuevoPrestamo.setFechaDevolucion(prestamoSeleccionado.getFechaDevolucion());

                // Actualizar el estado del préstamo en la base de datos
                prestamoData.modificarPrestamo(nuevoPrestamo);

                // Actualizar la lista de préstamos
                actualizarListaPrestamos();
            } else {
                JOptionPane.showMessageDialog(this, "No hay ejemplares disponibles para el libro seleccionado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un lector y un libro antes de modificar un préstamo.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un préstamo antes de modificarlo.");
    }
}


    private void eliminarPrestamo() {
        Prestamo prestamoSeleccionado = prestamoList.getSelectedValue();

        if (prestamoSeleccionado != null) {
            prestamoData.eliminarPrestamo(prestamoSeleccionado.getID());

            limpiarCamposPrestamo();
            actualizarListaPrestamos();
       } else {
            JOptionPane.showMessageDialog(this, "Seleccione un préstamo antes de eliminarlo.");
        }
    }

    private void limpiarCamposPrestamo() {
       
        fechaPrestamoDatePicker.setDate(null);
        fechaDevolucionDatePicker.setDate(null);
        estadoComboBox.setSelectedIndex(0);  // Restaurar el estado al valor predeterminado
        libroComboBox.setSelectedIndex(0);
        lectorComboBox.setSelectedIndex(0);
        estadoOriginal = null;
    }

    private void actualizarListaPrestamos() {
        prestamoListModel.clear();
        List<Prestamo> prestamos = prestamoData.obtenerTodosLosPrestamos();

        for (Prestamo prestamo : prestamos) {
            prestamoListModel.addElement(prestamo);
        }
    }
}
