package universidadejemplo.Vistas.Administracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotasForm {
    private JPanel mainPanel;
    private JComboBox<String> alumnoComboBox;
    private JComboBox<String> materiaComboBox;
    private JTextField notaField;
    private JButton guardarButton;
    private JButton cancelarButton;

    public NotasForm() {
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

        mainPanel.add(new JLabel("Nota:"));
        notaField = new JTextField();
        mainPanel.add(notaField);

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario y guardar la nota en la base de datos
                String alumnoSeleccionado = (String) alumnoComboBox.getSelectedItem();
                String materiaSeleccionada = (String) materiaComboBox.getSelectedItem();
                double nota = Double.parseDouble(notaField.getText());

                // Lógica para guardar la nota en la base de datos
                // ...

                // Actualizar la interfaz gráfica, si es necesario
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
}
