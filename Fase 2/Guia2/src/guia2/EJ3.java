/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EJ3 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestión de Productos");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        String[] categorias = {"Electrónica", "Ropa", "Alimentos", "Otro"};
        JComboBox<String> categoryComboBox = new JComboBox<>(categorias);
        categoryComboBox.setBounds(10, 10, 150, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(10, 40, 150, 25);
        JTextField priceField = new JTextField();
        priceField.setBounds(170, 40, 100, 25);

        JButton addButton = new JButton("Agregar producto");
        addButton.setBounds(10, 70, 150, 25);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Categoría");
        model.addColumn("Precio");
        JTable productTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(productTable);
        tableScrollPane.setBounds(10, 100, 480, 150);

        frame.add(categoryComboBox);
        frame.add(nameField);
        frame.add(priceField);
        frame.add(addButton);
        frame.add(tableScrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoria = (String) categoryComboBox.getSelectedItem();
                String nombre = nameField.getText();
                String precio = priceField.getText();

                if (!nombre.isEmpty() && !precio.isEmpty()) {
                    Object[] rowData = {nombre, categoria, precio};
                    model.addRow(rowData);
                    nameField.setText("");
                    priceField.setText("");
                }
            }
        });
        frame.setVisible(
                true);
    }

}
