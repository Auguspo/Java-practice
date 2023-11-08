package universidadejemplo.Vistas.Administracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscripcionForm {
    private JPanel mainPanel;
    private JComboBox<String> alumnoComboBox;
    private JComboBox<String> materiaComboBox;
    private JButton inscribirButton;
    private JButton anularButton;
    private JButton salirButton;

    public InscripcionForm() {
        mainPanel = new JPanel(new GridLayout(4, 2));

        // Cargar datos en los ComboBoxes (alumnos y materias) desde la base de datos o alguna otra fuente

        alumnoComboBox = new JComboBox<>();
        // Cargar lista de alumnos
        alumnoComboBox.addItem("Alumno 1");
        alumnoComboBox.addItem("Alumno 2");
        // ...

        materiaComboBox = new JComboBox<>();
        // Cargar lista de materias
        materiaComboBox.addItem("Materia 1");
        materiaComboBox.addItem("Materia 2");
        // ...

        mainPanel.add(new JLabel("Seleccione un alumno:"));
        mainPanel.add(alumnoComboBox);

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);

        inscribirButton = new JButton("Inscribir");
        anularButton = new JButton("Anular Inscripción");
        salirButton = new JButton("Salir");

        inscribirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para inscribir al alumno en la materia seleccionada
                // ...

                // Actualizar la interfaz gráfica, si es necesario
            }
        });

        anularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para anular la inscripción del alumno en la materia seleccionada
                // ...

                // Actualizar la interfaz gráfica, si es necesario
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana de inscripción
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });

        mainPanel.add(inscribirButton);
        mainPanel.add(anularButton);
        mainPanel.add(salirButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
