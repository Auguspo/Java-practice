/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author NOICE
 */
public class EJ2 {

    public static void main(String[] args) {
             JFrame frame = new JFrame("Convertidor de Temperatura");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Crear un campo de texto para la temperatura en grados Celsius
        JTextField celsiusField = new JTextField();
        celsiusField.setBounds(10, 10, 150, 25);

        // Crear un botón "Convertir"
        JButton convertButton = new JButton("Convertir");
        convertButton.setBounds(10, 40, 150, 25);

        // Agregar componentes a la ventana
        frame.add(celsiusField);
        frame.add(convertButton);

        // Agregar un ActionListener al botón
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = celsius * 9.0/5.0 + 32.0;
                    JOptionPane.showMessageDialog(frame, "La temperatura en Fahrenheit es: " + fahrenheit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese una temperatura válida en grados Celsius.");
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }}
