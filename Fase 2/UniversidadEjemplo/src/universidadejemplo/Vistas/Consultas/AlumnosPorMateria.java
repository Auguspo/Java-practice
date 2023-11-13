// AlumnosPorMateria.java
package universidadejemplo.Vistas.Consultas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.AccesoADatos.MateriaData;
import universidadejemplo.Entidades.Alumno;

public class AlumnosPorMateria {

    private JPanel mainPanel;
    private JComboBox<String> materiaComboBox;
    private JButton consultarButton;

    private InscripcionData inscripcionData;
    
    // Constructor
    public AlumnosPorMateria() {
        mainPanel = new JPanel(new GridLayout(2, 2));

        materiaComboBox = new JComboBox<>();

        cargarMaterias();

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);
        
        inscripcionData = new InscripcionData();
        
        consultarButton = new JButton("Consultar");

       consultarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    String materiaSeleccionada = (String) materiaComboBox.getSelectedItem();
    System.out.println("Materia seleccionada: " + materiaSeleccionada);

    Integer idMateria = obtenerIdMateriaPorNombre(materiaSeleccionada);

    if (idMateria != null) {
        System.out.println("ID de la materia: " + idMateria);

        List<Alumno> alumnosEnMateria = inscripcionData.obtenerAlumnosXMateria(idMateria);

        if (alumnosEnMateria != null && !alumnosEnMateria.isEmpty()) {
            System.out.println("Lista de alumnos encontrada. Mostrando resultados:");

            StringBuilder mensaje = new StringBuilder("Alumnos en la materia:\n");

            for (Alumno alumno : alumnosEnMateria) {
                mensaje.append(alumno.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(null, mensaje.toString(), "Alumnos por Materia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("No se encontraron alumnos en la materia.");
            JOptionPane.showMessageDialog(null, "No se encontraron alumnos en la materia.", "Alumnos por Materia", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        System.out.println("Error: Materia no encontrada.");
        JOptionPane.showMessageDialog(null, "Error: Materia no encontrada.", "Alumnos por Materia", JOptionPane.ERROR_MESSAGE);
    }
}
        });

        mainPanel.add(consultarButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void cargarMaterias() {
        MateriaData materiaData = new MateriaData();

        List<String> materias = materiaData.listarNombresMaterias();

        materiaComboBox.removeAllItems();

        for (String materia : materias) {
            materiaComboBox.addItem(materia);
        }
    }

    private int obtenerIdMateriaPorNombre(String nombreMateria) {
        MateriaData materiaData = new MateriaData();
        return materiaData.obtenerIdMateriaPorNombre(nombreMateria);
    }
}
