package com.biblioteca.ui;

import com.biblioteca.data.LibroData;
import com.biblioteca.model.Libro;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class LibroPanel extends JPanel {

    private LibroData libroData;

    private JList<String> libroList;
    private DefaultListModel<String> libroListModel;

    private JTextField isbnField, nombreField, generoField, editorialField, autorField, estadoField, cantidadField;

    public LibroPanel(LibroData libroData) {
        this.libroData = libroData;

        setLayout(new BorderLayout());

        libroListModel = new DefaultListModel<>();
        libroList = new JList<>(libroListModel);

        JScrollPane scrollPane = new JScrollPane(libroList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes de 5 en todos los lados

        // Crear los JLabel y JTextField y agregarlos al panel con el diseño de cuadrícula
        agregarCampo(inputPanel, gbc, "ISBN:", isbnField = new JTextField());
        agregarCampo(inputPanel, gbc, "Nombre:", nombreField = new JTextField());
        agregarCampo(inputPanel, gbc, "Género:", generoField = new JTextField());
        agregarCampo(inputPanel, gbc, "Editorial:", editorialField = new JTextField());
        agregarCampo(inputPanel, gbc, "Autor:", autorField = new JTextField());
        agregarCampo(inputPanel, gbc, "Estado:", estadoField = new JTextField());
        agregarCampo(inputPanel, gbc, "Cantidad:", cantidadField = new JTextField());

        // Resto del código para los botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        JButton agregarButton = new JButton("Agregar Libro");
        JButton modificarButton = new JButton("Modificar Libro");
        JButton eliminarButton = new JButton("Eliminar Libro");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarLibro();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        inputPanel.add(agregarButton, gbc);

        gbc.gridx = 1;
        inputPanel.add(modificarButton, gbc);

        gbc.gridx = 2;
        inputPanel.add(eliminarButton, gbc);

        // Agregar el panel de entrada al sur del panel principal
        add(inputPanel, BorderLayout.SOUTH);

        // Agregar el ListSelectionListener al JList
        libroList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Cuando se selecciona un libro, completa los campos
                    seleccionarLibro();
                }
            }
        });

        // Actualizar la lista de libros
        actualizarListaLibros();
    }

    // Método para agregar un campo al panel de entrada con un diseño de cuadrícula
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

    private void seleccionarLibro() {
        // Obtiene el índice del libro seleccionado
        int selectedIndex = libroList.getSelectedIndex();

        if (selectedIndex != -1) {
            // Obtiene el ISBN del libro seleccionado
            String selectedISBN = libroList.getModel().getElementAt(selectedIndex).split(" - ")[0];

            // Obtiene el libro de la base de datos usando el ISBN
            Libro selectedLibro = libroData.obtenerLibroPorISBN(selectedISBN);

            // Rellena los campos con los datos del libro seleccionado
            if (selectedLibro != null) {
                isbnField.setText(selectedLibro.getISBN());
                nombreField.setText(selectedLibro.getNombre());
                generoField.setText(selectedLibro.getGenero());
                editorialField.setText(selectedLibro.getEditorial());
                autorField.setText(selectedLibro.getAutor());
                estadoField.setText(selectedLibro.getEstado());
                cantidadField.setText(String.valueOf(selectedLibro.getCantidad()));
            }
        }
    }

    private void agregarLibro() {
        String isbn = isbnField.getText();
        String nombre = nombreField.getText();
        String genero = generoField.getText();
        String editorial = editorialField.getText();
        String autor = autorField.getText();
        String estado = estadoField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());

        Libro nuevoLibro = new Libro(isbn, nombre, genero, editorial, autor, estado, cantidad);
        libroData.agregarLibro(nuevoLibro);

        limpiarCamposLibro();
        actualizarListaLibros();
    }

    private void modificarLibro() {
        String isbn = isbnField.getText();
        String nombre = nombreField.getText();
        String genero = generoField.getText();
        String editorial = editorialField.getText();
        String autor = autorField.getText();
        String estado = estadoField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());

        Libro libroExistente = libroData.obtenerLibroPorISBN(isbn);

        if (libroExistente != null) {
            libroExistente.setNombre(nombre);
            libroExistente.setGenero(genero);
            libroExistente.setEditorial(editorial);
            libroExistente.setAutor(autor);
            libroExistente.setEstado(estado);
            libroExistente.setCantidad(cantidad);

            libroData.actualizarLibro(libroExistente);

            limpiarCamposLibro();
            actualizarListaLibros();
        } else {
            JOptionPane.showMessageDialog(this, "El libro con ISBN " + isbn + " no existe.");
        }
    }

    private void eliminarLibro() {
        String isbn = isbnField.getText();

        libroData.eliminarLibro(isbn);
        JOptionPane.showMessageDialog(this, "Libro eliminado exitosamente.");

        limpiarCamposLibro();
        actualizarListaLibros();
    }

    private void actualizarListaLibros() {
        libroListModel.clear();
        List<Libro> libros = libroData.obtenerTodosLosLibros();

        for (Libro libro : libros) {
            libroListModel.addElement(libro.getISBN() + " - " + libro.getNombre() + " - " + libro.getGenero() + " - " + libro.getEditorial() + " - " + libro.getAutor() + " - " + libro.getEstado() + " - " + libro.getCantidad());
        }
    }

    private void limpiarCamposLibro() {
        isbnField.setText("");
        nombreField.setText("");
        generoField.setText("");
        editorialField.setText("");
        autorField.setText("");
        estadoField.setText("");
        cantidadField.setText("");
    }
}
