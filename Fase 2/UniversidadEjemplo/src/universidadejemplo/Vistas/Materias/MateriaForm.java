package universidadejemplo.Vistas.Materias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import universidadejemplo.AccesoADatos.MateriaData;
import universidadejemplo.Entidades.Materia;

public class MateriaForm {

    private JPanel mainPanel;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField añoField;
    private JButton guardarButton;
    private JButton cancelarButton;

    public MateriaForm() {
        mainPanel = new JPanel(new GridLayout(4, 2));

        mainPanel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        mainPanel.add(codigoField);

        mainPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        mainPanel.add(nombreField);

        mainPanel.add(new JLabel("Año:"));
        añoField = new JTextField();
        mainPanel.add(añoField);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario y guardar la materia
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                int año = Integer.parseInt(añoField.getText());
                Materia materia = new Materia(codigo, nombre, año, true); // Activo se establece en "true"

                // Lógica para guardar la materia
                MateriaData materiaData = new MateriaData();
                materiaData.guardarMateria(materia);

                // Cerrar la ventana del formulario después de guardar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario y guardar la materia
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                int año = Integer.parseInt(añoField.getText());
                Materia materia = new Materia(codigo, nombre, año, true); // Activo se establece en "true"

                // Lógica para guardar la materia
                // ...
                // Cerrar la ventana del formulario después de guardar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });
        mainPanel.add(guardarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana del formulario sin guardar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });
        mainPanel.add(cancelarButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario de Materia");
        MateriaForm materiaForm = new MateriaForm();
        frame.add(materiaForm.getMainPanel());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana sin salir de la aplicación
        frame.setVisible(true);
    }
}
