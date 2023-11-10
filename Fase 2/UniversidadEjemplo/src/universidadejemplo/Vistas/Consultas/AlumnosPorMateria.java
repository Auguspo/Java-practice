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

    public AlumnosPorMateria() {
        mainPanel = new JPanel(new GridLayout(2, 2));

        materiaComboBox = new JComboBox<>();

        // Cargar la lista de materias desde la base de datos
        cargarMaterias();

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);

        consultarButton = new JButton("Consultar");

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la materia seleccionada desde el ComboBox
                String materiaSeleccionada = (String) materiaComboBox.getSelectedItem();

                // Realizar la consulta de alumnos por materia y mostrar los resultados
                // En este ejemplo, asumí que la materia tiene un ID (puedes ajustarlo según tu implementación)
                int idMateria = obtenerIdMateriaPorNombre(materiaSeleccionada);
                System.out.println(idMateria);
                // Obtener la lista de alumnos en la materia seleccionada
                List<Alumno> alumnosEnMateria = inscripcionData.obtenerAlumnosXMateria(idMateria);

                // Verificar si la lista de alumnos no es nula y tiene elementos
                if (alumnosEnMateria != null && !alumnosEnMateria.isEmpty()) {
                    // Crear un mensaje con la lista de alumnos
                    StringBuilder mensaje = new StringBuilder("Alumnos en la materia:\n");

                    for (Alumno alumno : alumnosEnMateria) {
                        mensaje.append(alumno.toString()).append("\n");
                    }

                    // Mostrar la lista de alumnos en una ventana de mensaje
                    JOptionPane.showMessageDialog(null, mensaje.toString(), "Alumnos por Materia", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron alumnos en la materia.", "Alumnos por Materia", JOptionPane.INFORMATION_MESSAGE);
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

        // Obtener la lista de nombres de materias desde la base de datos
        List<String> materias = materiaData.listarNombresMaterias();

        // Limpiar el ComboBox antes de agregar las nuevas materias
        materiaComboBox.removeAllItems();

        // Agregar las materias al ComboBox
        for (String materia : materias) {
            materiaComboBox.addItem(materia);
        }
    }

    private int obtenerIdMateriaPorNombre(String nombreMateria) {
        // Implementa la lógica para obtener el ID de la materia por su nombre
        // Puedes usar la MateriaData para realizar la consulta a la base de datos
         MateriaData materiaData = new MateriaData();
        return materiaData.obtenerIdMateriaPorNombre(nombreMateria);
    }

}
