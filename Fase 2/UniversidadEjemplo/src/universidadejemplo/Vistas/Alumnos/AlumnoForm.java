package universidadejemplo.Vistas.Alumnos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.Entidades.Alumno;

public class AlumnoForm {

    private JPanel mainPanel;
    private JTextField dniField;
    private JTextField apellidoField;
    private JTextField nombreField;
    private JTextField fechaNacField;
    private JCheckBox estadoField;

    public AlumnoForm() {
        mainPanel = new JPanel(new GridLayout(6, 2));

        dniField = new JTextField();
        apellidoField = new JTextField();
        nombreField = new JTextField();
        fechaNacField = new JTextField();
        estadoField = new JCheckBox();

        JLabel dniLabel = new JLabel("DNI:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel fechaNacLabel = new JLabel("Fecha de Nacimiento:");
        JLabel estadoLabel = new JLabel("Estado:");

        JButton nuevoButton = new JButton("Nuevo");
        JButton eliminarButton = new JButton("Eliminar");
        JButton guardarButton = new JButton("Guardar");
        JButton buscarButton = new JButton("Buscar");
        JButton salirButton = new JButton("Salir");

        mainPanel.add(dniLabel);
        mainPanel.add(dniField);
        mainPanel.add(buscarButton);

        mainPanel.add(apellidoLabel);
        mainPanel.add(apellidoField);
        mainPanel.add(nombreLabel);
        mainPanel.add(nombreField);
        mainPanel.add(estadoLabel);
        mainPanel.add(estadoField);
        mainPanel.add(nombreField);
        mainPanel.add(fechaNacLabel);
        mainPanel.add(fechaNacField);

        mainPanel.add(nuevoButton);
        mainPanel.add(eliminarButton);
        mainPanel.add(guardarButton);
        mainPanel.add(salirButton);

        AlumnoData alumnoData = new AlumnoData();

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dniField.setText("");
                apellidoField.setText("");
                nombreField.setText("");
                fechaNacField.setText("");
                estadoField.setSelected(false);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniText = dniField.getText();
                if (!dniText.isEmpty()) {
                    int dni = Integer.parseInt(dniText);
                    alumnoData.eliminarAlumnoPorDni(dni);
                    dniField.setText("");
                    apellidoField.setText("");
                    nombreField.setText("");
                    fechaNacField.setText("");
                    estadoField.setSelected(false);
                }
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dni = Integer.parseInt(dniField.getText());
                String apellido = apellidoField.getText();
                String nombre = nombreField.getText();
                LocalDate fechaNac = LocalDate.parse(fechaNacField.getText());
                boolean activo = estadoField.isSelected();

                Alumno alumno = new Alumno(dni, apellido, nombre, fechaNac, activo);
                alumnoData.guardarAlumno(alumno);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniText = dniField.getText();
                if (!dniText.isEmpty()) {
                    int dni = Integer.parseInt(dniText);
                    Alumno alumno = alumnoData.buscarAlumnoPorDni(dni);
                    if (alumno != null) {
                        apellidoField.setText(alumno.getApellido());
                        nombreField.setText(alumno.getNombre());
                        fechaNacField.setText(alumno.getFechaNac().toString());
                        estadoField.setSelected(alumno.isActivo());
                    }
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Cierra la aplicación
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario de Alumno");
        AlumnoForm alumnoForm = new AlumnoForm();
        frame.add(alumnoForm.getMainPanel());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
