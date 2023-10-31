package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.*;

public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadejemplo", "root", "");

            String sql = "insert into alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                    + "values(52745628,'Lopez','Juan', ' " + LocalDate.of(2000, Month.AUGUST, 29)
                    + "',true);";

            PreparedStatement ps = conn.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia agregada exitosamente");

            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Debe agregar los driver al proyecto!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

}
