package universidadejemplo.Vistas.Consultas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnosPorMateria {
    private JPanel mainPanel;
    private JComboBox<String> materiaComboBox;
    private JButton consultarButton;

    public AlumnosPorMateria() {
        mainPanel = new JPanel(new GridLayout(2, 2));

        materiaComboBox = new JComboBox<>();
        // Cargar lista de materias desde la base de datos o alguna otra fuente
        materiaComboBox.addItem("Materia 1");
        materiaComboBox.addItem("Materia 2");
        // ...

        mainPanel.add(new JLabel("Seleccione una materia:"));
        mainPanel.add(materiaComboBox);

        consultarButton = new JButton("Consultar");

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la materia seleccionada desde el ComboBox
                String materiaSeleccionada = (String) materiaComboBox.getSelectedItem();

                // Realizar la consulta de alumnos por materia y mostrar los resultados
                // ...

                // Puedes mostrar los resultados en un nuevo JFrame, JPanel o de la manera que prefieras
                // Ejemplo: JOptionPane.showMessageDialog(null, "Alumnos inscritos en " + materiaSeleccionada + ": ...");
            }
        });

        mainPanel.add(consultarButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
