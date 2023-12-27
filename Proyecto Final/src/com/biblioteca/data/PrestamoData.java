package com.biblioteca.data;

import com.biblioteca.model.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoData {

    private LectorData lectorData;

    private Connection conexion;

    public PrestamoData() {
        conexion = Conexion.getConexion();
    }
 public void agregarPrestamoVerificandoLector(Prestamo prestamo) {
    try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Prestamo (LectorDNI, EjemplarID, ISBN, FechaPrestamo, FechaDevolucion, Estado) VALUES (?, ?, ?, ?, ?, ?)")) {
        statement.setString(1, prestamo.getLectorDNI());
        statement.setInt(2, prestamo.getEjemplarID());
        statement.setString(3, prestamo.getISBN());
        statement.setDate(4, prestamo.getFechaPrestamo());
        statement.setDate(5, prestamo.getFechaDevolucion());
        statement.setString(6, prestamo.getEstado());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Actualizar el estado del ejemplar a "Prestado"
    String libroISBN = prestamo.getISBN();
    int ejemplarID = prestamo.getEjemplarID();
    actualizarEstadoEjemplar(libroISBN, ejemplarID, "Prestado");

    // Verificar el estado del lector y actualizarlo
   
}

// Nuevo método para verificar y actualizar el estado del lector




    private void actualizarEstadoEjemplar(String libroISBN, int ejemplarID, String nuevoEstado) {
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Ejemplar SET Estado = ? WHERE LibroISBN = ? AND ID = ?")) {
            statement.setString(1, nuevoEstado);
            statement.setString(2, libroISBN);
            statement.setInt(3, ejemplarID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarEstadoLector(String lectorDNI, String nuevoEstado) {
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Lector SET estado = ? WHERE DNI = ?")) {
            statement.setString(1, nuevoEstado);
            statement.setString(2, lectorDNI);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public List<Prestamo> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Prestamo")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setID(resultSet.getInt("ID"));
                prestamo.setLectorDNI(resultSet.getString("LectorDNI"));
                prestamo.setEjemplarID(resultSet.getInt("EjemplarID"));
                prestamo.setISBN(resultSet.getString("ISBN"));
                prestamo.setFechaPrestamo(resultSet.getDate("FechaPrestamo"));
                prestamo.setFechaDevolucion(resultSet.getDate("FechaDevolucion"));
                prestamo.setEstado(resultSet.getString("Estado"));

                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

    public Prestamo obtenerPrestamo(int prestamoID) {
        Prestamo prestamo = null;

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Prestamo WHERE ID = ?")) {
            statement.setInt(1, prestamoID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                prestamo = new Prestamo();
                prestamo.setID(resultSet.getInt("ID"));
                prestamo.setLectorDNI(resultSet.getString("LectorDNI"));
                prestamo.setEjemplarID(resultSet.getInt("EjemplarID"));
                prestamo.setISBN(resultSet.getString("ISBN"));
                prestamo.setFechaPrestamo(resultSet.getDate("FechaPrestamo"));
                prestamo.setFechaDevolucion(resultSet.getDate("FechaDevolucion"));
                prestamo.setEstado(resultSet.getString("Estado"));
            }
        } catch (SQLException e) {

        }

        return prestamo;
    }
   

    public Prestamo obtenerPrestamoPorID(int ID) {
        Prestamo prestamo = null;

        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Prestamo WHERE ID = ?")) {
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                prestamo = new Prestamo(
                        resultSet.getInt("ID"),
                        resultSet.getString("LectorDNI"),
                        resultSet.getInt("EjemplarID"),
                        resultSet.getDate("FechaPrestamo"),
                        resultSet.getDate("FechaDevolucion"),
                        resultSet.getString("Estado"), resultSet.getString("ISBN")
                );
            }
        } catch (SQLException e) {

        }

        return prestamo;
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        try (PreparedStatement statement = conexion.prepareStatement(
                "UPDATE Prestamo SET LectorDNI = ?, EjemplarID = ?, FechaPrestamo = ?, FechaDevolucion = ?, Estado = ? WHERE ID = ?")) {
            statement.setString(1, prestamo.getLectorDNI());
            statement.setInt(2, prestamo.getEjemplarID());
            statement.setDate(3, prestamo.getFechaPrestamo());
            statement.setDate(4, prestamo.getFechaDevolucion());
            statement.setString(5, prestamo.getEstado());
            statement.setInt(6, prestamo.getID());

            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
   public int obtenerEjemplarDisponible(String libroISBN) {
        int ejemplarID = -1;

        try (PreparedStatement statement = conexion.prepareStatement(
                "SELECT ID FROM Ejemplar WHERE LibroISBN = ? AND Estado = 'Disponible' LIMIT 1")) {
            statement.setString(1, libroISBN);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ejemplarID = resultSet.getInt("ID");
            }
        } catch (SQLException e) {

        }

        return ejemplarID;
    }
    public void eliminarPrestamo(int ID) {
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Prestamo WHERE ID = ?")) {
            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

 




public void modificarPrestamo(Prestamo prestamo) {
    try (PreparedStatement statement = conexion.prepareStatement(
            "UPDATE Prestamo SET LectorDNI = ?, EjemplarID = ?, Estado = ?, ISBN = ?, FechaPrestamo = ?, FechaDevolucion = ? WHERE ID = ?")) {
        statement.setString(1, prestamo.getLectorDNI());
        statement.setInt(2, prestamo.getEjemplarID());
        statement.setString(3, prestamo.getEstado());
        statement.setString(4, prestamo.getISBN());
        statement.setDate(5, prestamo.getFechaPrestamo());
        statement.setDate(6, prestamo.getFechaDevolucion());
        statement.setInt(7, prestamo.getID());

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
