/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.data;

import com.biblioteca.model.Libro;
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
public class LibroData {

    private Connection conexion = null;

    public LibroData() {
        conexion = Conexion.getConexion();
    }

    public void liberarEjemplar(String libroISBN, int ejemplarID) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "UPDATE Ejemplar SET Estado = 'Disponible' WHERE LibroISBN = ? AND ID = ?")) {
            statement.setString(1, libroISBN);
            statement.setInt(2, ejemplarID);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
        }
    }

    // Método para obtener todos los libros de la base de datos
    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Libro")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Libro libro = new Libro(
                        resultSet.getString("ISBN"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Genero"),
                        resultSet.getString("Editorial"),
                        resultSet.getString("Autor"),
                        resultSet.getString("Estado"),
                        resultSet.getInt("Cantidad")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

  public List<String> obtenerISBNLibrosDisponibles() {
    List<String> isbnList = new ArrayList<>();

    try (PreparedStatement statement = conexion.prepareStatement("SELECT ISBN FROM Libro WHERE Estado = 'Disponible'")) {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String isbn = resultSet.getString("ISBN");
            isbnList.add(isbn);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return isbnList;
}
public List<String> obtenerISBNLibros() {
    List<String> isbnList = new ArrayList<>();

    try (PreparedStatement statement = conexion.prepareStatement("SELECT ISBN FROM Libro ")) {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String isbn = resultSet.getString("ISBN");
            isbnList.add(isbn);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return isbnList;
}

    // Método para obtener un libro por su ISBN
    public Libro obtenerLibroPorISBN(String ISBN) {
        Libro libro = null;

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Libro WHERE ISBN = ?")) {
            statement.setString(1, ISBN);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                libro = new Libro(
                        resultSet.getString("ISBN"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Genero"),
                        resultSet.getString("Editorial"),
                        resultSet.getString("Autor"),
                        resultSet.getString("Estado"),
                        resultSet.getInt("Cantidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }

    // Método para agregar un nuevo libro a la base de datos
    public void agregarLibro(Libro libro) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO Libro (ISBN, Nombre, Genero, Editorial, Autor, Estado, Cantidad) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, libro.getISBN());
            statement.setString(2, libro.getNombre());
            statement.setString(3, libro.getGenero());
            statement.setString(4, libro.getEditorial());
            statement.setString(5, libro.getAutor());
            statement.setString(6, libro.getEstado());
            statement.setInt(7, libro.getCantidad());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar la información de un libro en la base de datos
    public void actualizarLibro(Libro libro) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "UPDATE Libro SET Nombre = ?, Genero = ?, Editorial = ?, Autor = ?, Estado = ?, Cantidad = ? WHERE ISBN = ?")) {
            statement.setString(1, libro.getNombre());
            statement.setString(2, libro.getGenero());
            statement.setString(3, libro.getEditorial());
            statement.setString(4, libro.getAutor());
            statement.setString(5, libro.getEstado());
            statement.setInt(6, libro.getCantidad());
            statement.setString(7, libro.getISBN());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un libro de la base de datos por su ISBN
    public void eliminarLibro(String ISBN) {
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Libro WHERE ISBN = ?")) {
            statement.setString(1, ISBN);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
