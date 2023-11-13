package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;

public class InscripcionData {

    private Connection con;

    private MateriaData matData;

    private AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
        matData = new MateriaData();  // Added initialization
        aluData = new AlumnoData();  // Added initialization
    }

    public void guardarInscripcion(Inscripcion insc) {
        try {
            String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscripción guardada con éxito.");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la inscripción: " + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT idInscripcion, idAlumno, idMateria, nota FROM inscripcion";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idInscripcion = rs.getInt("idInscripcion");
                    int idAlumno = rs.getInt("idAlumno");
                    int idMateria = rs.getInt("idMateria");
                    double nota = rs.getDouble("nota");
                    Alumno alumno = aluData.buscarAlumno(idAlumno);
                    Materia materia = matData.buscarMateria(idMateria);
                    Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota);
                    inscripciones.add(inscripcion);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripcionesPorAlumno = new ArrayList<>();
        try {
            String sql = "SELECT idInscripcion, idMateria, nota FROM inscripcion WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idInscripcion = rs.getInt("idInscripcion");
                int idMateria = rs.getInt("idMateria");
                double nota = rs.getDouble("nota");
                Materia materia = matData.buscarMateria(idMateria);
                Alumno alumno = aluData.buscarAlumno(id);
                Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota);
                inscripcionesPorAlumno.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones por alumno: " + ex.getMessage());
        }
        return inscripcionesPorAlumno;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion," + " materia WHERE inscripcion.idMateria = materia.idMateria\n" + "AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones " + ex.getMessage());
        }

        return materias;
    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        List<Materia> materiasNoCursadas = new ArrayList<>();

        // Obtener todas las materias disponibles
        List<Materia> todasLasMaterias = matData.listarMaterias();

        // Obtener las materias en las que el estudiante ya se ha inscrito
        List<Materia> materiasCursadas = obtenerMateriasCursadas(idAlumno);

        // Filtrar las materias no cursadas
        for (Materia materia : todasLasMaterias) {
            if (!materiasCursadas.contains(materia)) {
                materiasNoCursadas.add(materia);
            }
        }

        return materiasNoCursadas;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Inscripción eliminada con éxito.");
            } 

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar inscripción: " + ex.getMessage());
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Nota actualizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripción no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        List<Alumno> alumnosEnMateria = new ArrayList<>();

        try {
            String sql = "SELECT inscripcion.idAlumno FROM inscripcion WHERE inscripcion.idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                Alumno alumno = aluData.buscarAlumno(idAlumno);
                alumnosEnMateria.add(alumno);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia " + ex.getMessage());
        }

        return alumnosEnMateria;
    }

}
