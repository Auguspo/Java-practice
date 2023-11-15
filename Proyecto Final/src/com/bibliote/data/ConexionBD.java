/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliote.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {

    private static final String URL = "jdbc:mariadb://locahost/3306/";

    private static final String DB = "universidadejemplo";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "";

    private static Connection connection;

    private ConexionBD() {

    }

    public static Connection getConexion() throws ClassNotFoundException {
        if (connection == null) {
            try {
               Class.forName("org.mariadb.jbdc.Driver");
               // connection = DriverManager.getConnection(URL + DB, USUARIO ,PASSWORD);
                  connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD " + ex.getMessage());
            }

        }
        return connection;
    }

}
