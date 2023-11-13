package universidadejemplo.Vistas.Alumnos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        mainPanel = new JPanel(new GridLayout(8, 1)); // Cambiado a 8 filas para acomodar los elementos en el diseño deseado

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

        JPanel dniPanel = new JPanel(new GridLayout(1, 3)); // Un panel para agrupar DNI y su etiqueta
        dniPanel.add(dniLabel);
        dniPanel.add(dniField);
        dniPanel.add(buscarButton);

        JPanel nombreApellidoPanel = new JPanel(new GridLayout(1, 4)); // Un panel para agrupar Nombre, Apellido y Estado
        nombreApellidoPanel.add(nombreLabel);
        nombreApellidoPanel.add(nombreField);
        nombreApellidoPanel.add(apellidoLabel);
        nombreApellidoPanel.add(apellidoField);

        JPanel fechaEstadoPanel = new JPanel(new GridLayout(1, 2)); // Un panel para agrupar Fecha de Nacimiento y Estado
        fechaEstadoPanel.add(fechaNacLabel);
        fechaEstadoPanel.add(fechaNacField);
        fechaEstadoPanel.add(estadoLabel);
        fechaEstadoPanel.add(estadoField);

        // Agregado para colocar los botones en la última fila
        JPanel botonesPanel = new JPanel(new GridLayout(1, 4));
        botonesPanel.add(nuevoButton);
        botonesPanel.add(eliminarButton);
        botonesPanel.add(guardarButton);
        botonesPanel.add(salirButton);

        // Agregando los paneles al panel principal
        mainPanel.add(dniPanel);
        mainPanel.add(nombreApellidoPanel);
        mainPanel.add(fechaEstadoPanel);
        mainPanel.add(botonesPanel);

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
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario y guardar el alumno en la base de datos
                int dni = Integer.parseInt(dniField.getText());
                String apellido = apellidoField.getText();
                String nombre = nombreField.getText();
                LocalDate fechaNacimiento = obtenerFechaDesdeTexto(fechaNacField.getText());
                boolean estado = estadoField.isSelected();

                Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento, estado); // Activo se establece en "true"

                // Lógica para guardar el alumno en la base de datos usando AlumnoData
                alumnoData.guardarAlumno(alumno);

                // Cerrar la ventana del formulario después de guardar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el DNI del formulario y eliminar el alumno de la base de datos
                int dni = Integer.parseInt(dniField.getText());

                // Lógica para eliminar el alumno de la base de datos
                alumnoData.eliminarAlumnoPorDni(dni);

                // Cerrar la ventana del formulario después de eliminar
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                nuevoButton.doClick();
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

    private LocalDate obtenerFechaDesdeTexto(String fechaTexto) {
        // Ajusta el formato según cómo se ingresa la fecha en tu campo de texto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaTexto, formatter);
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
