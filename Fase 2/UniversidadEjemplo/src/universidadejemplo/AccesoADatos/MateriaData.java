package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Materia;

public class MateriaData {

    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public Materia guardarMateria(Materia materia) {
        try {
            String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada con éxito.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia: " + ex.getMessage());
        }

        return materia;
    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        try {
            String sql = "SELECT nombre, año, estado FROM materia WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la materia.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la materia: " + ex.getMessage());
        }

        return materia;
    }

    public Materia modificarMateria(Materia materia) {
        try {
            String sql = "UPDATE materia SET nombre = ?, año = ?, estado = ? WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la materia: " + ex.getMessage());
        }

        return materia;
    }

    public int eliminarMateria(int id) {
        int fila = 0;
        try {
            String sql = "DELETE FROM materia WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia: " + ex.getMessage());
        }

        return fila;
    }

    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT idMateria, nombre, año, estado FROM materia";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(rs.getBoolean("estado"));
                materias.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las materias: " + ex.getMessage());
        }

        return materias;
    }

    public List<Materia> obtenerTodasLasMaterias() {
        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idMateria = rs.getInt("idMateria");
                    String nombre = rs.getString("nombre");
                    int anioMateria = rs.getInt("año");
                    boolean activo = rs.getBoolean("estado");
                    Materia materia = new Materia(idMateria, nombre, anioMateria, activo);
                    materias.add(materia);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materias;
    }

    public List<String> listarNombresMaterias() {
        List<String> nombresMaterias = new ArrayList<>();

        try {
            String sql = "SELECT nombre FROM materia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreMateria = rs.getString("nombre");
                nombresMaterias.add(nombreMateria);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de materias: " + ex.getMessage());
        }

        return nombresMaterias;
    }

    public int obtenerIdMateriaPorNombre(String nombreMateria) {
        int idMateria = -1; // Valor por defecto si no se encuentra la materia

        try {
            String sql = "SELECT idMateria FROM materia WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreMateria);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idMateria = rs.getInt("idMateria");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID de la materia: " + ex.getMessage());
        }

        return idMateria;
    }

  
}
