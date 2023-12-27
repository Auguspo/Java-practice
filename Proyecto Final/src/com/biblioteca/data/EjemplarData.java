/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.data;

import com.biblioteca.model.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author NO ICE
 */
public class EjemplarData {

    private Connection conexion = null;

    public EjemplarData() {

        conexion = Conexion.getConexion();
    }

    public List<Ejemplar> obtenerTodosLosEjemplares() {
        List<Ejemplar> ejemplares = new ArrayList<>();

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM ejemplar")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ejemplar ejemplar = new Ejemplar(
                        resultSet.getInt("ID"),
                        resultSet.getString("LibroISBN"),
                        resultSet.getString("Estado")
                );
                ejemplares.add(ejemplar);

            }
            System.out.println(ejemplares);
        } catch (SQLException e) {
        }

        return ejemplares;
    }

    // Método para obtener un ejemplar por su ID
    public Ejemplar obtenerEjemplarPorID(int ID) {
        Ejemplar ejemplar = null;

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Ejemplar WHERE ID = ?")) {
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ejemplar = new Ejemplar(
                        resultSet.getInt("ID"),
                        resultSet.getString("LibroISBN"),
                        resultSet.getString("Estado")
                );
            }
        } catch (SQLException e) {
        }

        return ejemplar;
    }

    // Método para agregar un nuevo ejemplar a la base de datos
    // Método para agregar un nuevo ejemplar a la base de datos
    public void agregarEjemplar(Ejemplar ejemplar) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO Ejemplar (ID, LibroISBN, Estado) VALUES (?, ?, ?)")) {
            statement.setString(1, Integer.toString(ejemplar.getID()));
            statement.setString(2, ejemplar.getLibroISBN());
            statement.setString(3, ejemplar.getEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Método para actualizar la información de un ejemplar en la base de datos
    public void actualizarEjemplar(Ejemplar ejemplar) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "UPDATE Ejemplar SET LibroISBN = ?, Estado = ? WHERE ID = ?")) {
            statement.setString(1, ejemplar.getLibroISBN());
            statement.setString(2, ejemplar.getEstado());
            statement.setInt(3, ejemplar.getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un ejemplar de la base de datos por su ID
    public void eliminarEjemplar(int ejemplarID) {
        try {
            if (conexion.isClosed()) {
                conexion = Conexion.getConexion();
            }

            try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Ejemplar WHERE ID = ?")) {
                statement.setInt(1, ejemplarID);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar ejemplar: " + e.getMessage());
        }
    }}


