/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author NO ICE
 */
public class EJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Formulario de inicio de sesion");
        frame.setSize(305, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField emailField = new JTextField();
        emailField.setBounds(10, 10, 270, 25);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(10, 40, 270, 25);

        // Crear un botón "Registrar"
        JButton loginButton = new JButton("Registrar");
        loginButton.setBounds(10, 80, 270, 25);

        // Agregar componentes a la ventana
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.equals("alumno@ulp.edu.ar") && password.equals("12345678")) {
                    JOptionPane.showMessageDialog(frame, "¡Bienvenido!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuario y/o contraseña incorrectos");
                }
            }
        });
        frame.setVisible(true);
    }

}
