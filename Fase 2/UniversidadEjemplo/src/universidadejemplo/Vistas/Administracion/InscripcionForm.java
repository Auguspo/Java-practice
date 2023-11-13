package universidadejemplo.Vistas.Administracion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.AccesoADatos.MateriaData;

public class InscripcionForm {

    private JPanel mainPanel;
    private JComboBox<String> alumnoComboBox;
    private JComboBox<String> materiaComboBox;
    private JButton inscribirButton;
    private JButton anularButton;
    private JButton salirButton;

    private InscripcionData inscripcionData;

    public InscripcionForm() {
        mainPanel = new JPanel(new GridLayout(4, 2));

        alumnoComboBox = new JComboBox<>();
        materiaComboBox = new JComboBox<>();

        cargarAlumnosDesdeBaseDeDatos();
        cargarMateriasDesdeBaseDeDatos();

        mainPanel.add(new JLabel("Seleccione un alumno:"));
        mainPanel.add(alumnoComboBox);

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);

        inscribirButton = new JButton("Inscribir");
        anularButton = new JButton("Anular Inscripción");
        salirButton = new JButton("Salir");

        inscripcionData = new InscripcionData();
        inscribirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedAlumnoIndex = alumnoComboBox.getSelectedIndex();
                int selectedMateriaIndex = materiaComboBox.getSelectedIndex();

                if (selectedAlumnoIndex != -1 && selectedMateriaIndex != -1) {
                    Alumno selectedAlumno = obtenerAlumnoPorIndice(selectedAlumnoIndex);
                    Materia selectedMateria = obtenerMateriaPorIndice(selectedMateriaIndex);

                    // Lógica para inscribir al alumno en la materia seleccionada
                    inscripcionData.guardarInscripcion(new Inscripcion(selectedAlumno, selectedMateria, 0.0));

                    limpiarComboBoxes();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno y una materia antes de inscribir.");
                }
            }
        });

        anularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedAlumnoIndex = alumnoComboBox.getSelectedIndex();
                int selectedMateriaIndex = materiaComboBox.getSelectedIndex();

                if (selectedAlumnoIndex != -1 && selectedMateriaIndex != -1) {
                    Alumno selectedAlumno = obtenerAlumnoPorIndice(selectedAlumnoIndex);
                    Materia selectedMateria = obtenerMateriaPorIndice(selectedMateriaIndex);

                    // Lógica para anular la inscripción del alumno en la materia seleccionada
                    inscripcionData.borrarInscripcionMateriaAlumno(selectedAlumno.getIdAlumno(), selectedMateria.getIdMateria());
                    JOptionPane.showMessageDialog(null, "Inscripción eliminada con éxito.");

                    // Actualizar la interfaz gráfica, si es necesario
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno y una materia antes de anular la inscripción.");
                }
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

    private Alumno obtenerAlumnoPorIndice(int index) {
        AlumnoData alumnoData = new AlumnoData();
        List<Alumno> alumnos = alumnoData.obtenerTodosLosAlumnos();
        return alumnos.get(index);
    }

    private Materia obtenerMateriaPorIndice(int index) {
        MateriaData materiaData = new MateriaData();
        List<Materia> materias = materiaData.obtenerTodasLasMaterias();
        return materias.get(index);
    }

    private void cargarAlumnosDesdeBaseDeDatos() {
        AlumnoData alumnoData = new AlumnoData();
        List<Alumno> alumnos = alumnoData.obtenerTodosLosAlumnos();

        for (Alumno alumno : alumnos) {
            alumnoComboBox.addItem(alumno.getNombre() + " " + alumno.getApellido());
        }

        alumnoComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Alumno) {
                    Alumno alumno = (Alumno) value;
                    setText(alumno.getNombre() + " " + alumno.getApellido()); // Ajusta esto según las propiedades de tu clase Alumno
                }
                return this;
            }
        });
    }

    private void cargarMateriasDesdeBaseDeDatos() {
        MateriaData materiaData = new MateriaData();
        List<Materia> materias = materiaData.obtenerTodasLasMaterias();

        for (Materia materia : materias) {
            materiaComboBox.addItem(materia.getNombre());
        }
    }

    private void limpiarComboBoxes() {
        alumnoComboBox.setSelectedIndex(0);
        materiaComboBox.setSelectedIndex(0);
    }
}
