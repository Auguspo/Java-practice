/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.data;

import com.biblioteca.model.Lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NO ICE
 */
public class LectorData {

    private Connection conexion = null;

 public LectorData() {
     conexion = Conexion.getConexion();
     System.out.println("Conexión exitosa a la base de datos");
}

    // Método para obtener todos los lectores de la base de datos
    public List<Lector> obtenerTodosLosLectores() {
        List<Lector> lectores = new ArrayList<>();

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM lector")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lector lector = new Lector(
                        resultSet.getString("DNI"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Domicilio"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Estado")
                );
                lectores.add(lector);
            }
        } catch (SQLException e) {
        }

        return lectores;
    }

    // Método para obtener un lector por su DNI
    public Lector obtenerLectorPorDNI(String DNI) {
        Lector lector = null;

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lector WHERE DNI = ?")) {
            statement.setString(1, DNI);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                lector = new Lector(
                        resultSet.getString("DNI"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Domicilio"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Activo")
                );
            } 
       } catch (SQLException e) {
        }

        return lector;
    }

    // Método para agregar un nuevo lector a la base de datos
    public void agregarLector(Lector lector) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO Lector (DNI, Nombre, Domicilio, Telefono, Estado) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, lector.getDNI());
            statement.setString(2, lector.getNombre());
            statement.setString(3, lector.getDomicilio());
            statement.setString(4, lector.getTelefono());
            statement.setBoolean(5, lector.isActivo());

            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Método para actualizar la información de un lector en la base de datos
    public void actualizarLector(Lector lector) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "UPDATE Lector SET Nombre = ?, Domicilio = ?, Telefono = ?, Estado = ? WHERE DNI = ?")) {
            statement.setString(1, lector.getNombre());
            statement.setString(2, lector.getDomicilio());
            statement.setString(3, lector.getTelefono());
            statement.setBoolean(4, lector.isActivo());
            statement.setString(5, lector.getDNI());

            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Método para eliminar un lector de la base de datos por su DNI
    public void eliminarLector(String DNI) {
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Lector WHERE DNI = ?")) {
            statement.setString(1, DNI);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    


 

}
