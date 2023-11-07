package universidadejemplo.Vistas;

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

            
          
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Debe agregar los driver al proyecto!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

}
