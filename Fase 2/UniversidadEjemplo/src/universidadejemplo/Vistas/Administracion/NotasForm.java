package universidadejemplo.Vistas.Administracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.AccesoADatos.MateriaData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;

public class NotasForm {

    private JPanel mainPanel;
    private JComboBox<Alumno> alumnoComboBox;
    private JComboBox<String> materiaComboBox;
    private JTextField notaField;
    private JButton guardarButton;
    private JButton cancelarButton;

    public NotasForm() {
        mainPanel = new JPanel(new GridLayout(4, 2));

        // Cargar datos en los ComboBoxes (alumnos y materias) desde la base de datos
        cargarAlumnosDesdeBaseDeDatos();
        cargarMateriasDesdeBaseDeDatos();

        mainPanel.add(new JLabel("Seleccione un alumno:"));
        mainPanel.add(alumnoComboBox);

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);

        mainPanel.add(new JLabel("Nota:"));
        notaField = new JTextField();
        mainPanel.add(notaField);

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario
                Alumno alumnoSeleccionado = (Alumno) alumnoComboBox.getSelectedItem();
                Materia materiaSeleccionada = obtenerMateriaPorNombre((String) materiaComboBox.getSelectedItem());
                double nota = Double.parseDouble(notaField.getText());

                // Verificar si se seleccionó un alumno y una materia
                if (alumnoSeleccionado != null && materiaSeleccionada != null) {
                    // Lógica para guardar la nota en la base de datos
                    InscripcionData inscripcionData = new InscripcionData();
                    Inscripcion inscripcion = new Inscripcion(alumnoSeleccionado, materiaSeleccionada, nota);
                    inscripcionData.guardarInscripcion(inscripcion);

                    // Actualizar la interfaz gráfica, si es necesario
                    JOptionPane.showMessageDialog(null, "Nota guardada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno y una materia antes de guardar la nota.");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana de notas sin guardar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });

        mainPanel.add(guardarButton);
        mainPanel.add(cancelarButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void cargarAlumnosDesdeBaseDeDatos() {
        AlumnoData alumnoData = new AlumnoData();
        List<Alumno> alumnos = alumnoData.obtenerTodosLosAlumnos();

        alumnoComboBox = new JComboBox<>(alumnos.toArray(new Alumno[0]));

        alumnoComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Alumno) {
                    Alumno alumno = (Alumno) value;
                    setText(alumno.getNombre() + " " + alumno.getApellido());
                }
                return this;
            }
        });
    }

    private Materia obtenerMateriaPorNombre(String nombreMateria) {
        MateriaData materiaData = new MateriaData();

        // Obtener la lista de todas las materias desde la base de datos
        List<Materia> materias = materiaData.obtenerTodasLasMaterias();

        // Iterar sobre la lista de materias y buscar la que coincide con el nombre
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombreMateria)) {
                // Utilizar la función buscarMateria con el ID de la materia encontrada
                return materiaData.buscarMateria(materia.getIdMateria());
            }
        }

        // Si no se encuentra la materia, puedes devolver null o lanzar una excepción según tus necesidades
        return null;
    }

    private void cargarMateriasDesdeBaseDeDatos() {
        MateriaData materiaData = new MateriaData();
        List<Materia> materias = materiaData.obtenerTodasLasMaterias();

        materiaComboBox = new JComboBox<>(); // Inicializa materiaComboBox

        for (Materia materia : materias) {
            materiaComboBox.addItem(materia.getNombre());
        }
    }
}
