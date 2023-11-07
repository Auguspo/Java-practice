package universidadejemplo.Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.Entidades.Alumno;

public class FrontWindows {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de universidad");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu alumnoMenu = new JMenu("Alumno");
        JMenuItem alumnoSubMenu = new JMenuItem("Formulario de alumno");

        alumnoSubMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formularioAlumnoFrame = new JFrame("Formulario de Alumno");
                formularioAlumnoFrame.setLayout(new GridLayout(7, 2));

                JTextField dniField = new JTextField();
                JTextField apellidoField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField fechaNacField = new JTextField();
                JRadioButton estadoField = new JRadioButton();

                JButton nuevoButton = new JButton("Nuevo");
                JButton eliminarButton = new JButton("Eliminar");
                JButton guardarButton = new JButton("Guardar");
                JButton buscarButton = new JButton("Buscar");
                JButton salirButton = new JButton("Salir");

                nuevoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para limpiar los campos del formulario
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
                            // Llamar a la función para eliminar el alumno por DNI
                            AlumnoData alumnoData = new AlumnoData();
                            alumnoData.eliminarAlumnoPorDni(dni);
                            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                            nuevoButton.doClick(); // Limpia los campos después de eliminar
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
                        AlumnoData alumnoData = new AlumnoData();
                        alumnoData.guardarAlumno(alumno);
                        JOptionPane.showMessageDialog(null, "Alumno guardado correctamente");
                    }
                });

                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dniText = dniField.getText();
                        if (!dniText.isEmpty()) {
                            int dni = Integer.parseInt(dniText);
                            AlumnoData alumnoData = new AlumnoData();
                            Alumno alumno = alumnoData.buscarAlumnoPorDni(dni);
                            if (alumno != null) {
                                apellidoField.setText(alumno.getApellido());
                                nombreField.setText(alumno.getNombre());
                                fechaNacField.setText(alumno.getFechaNac().toString());
                                estadoField.setSelected(alumno.isActivo());
                            } else {
                                JOptionPane.showMessageDialog(null, "Alumno no encontrado");
                            }
                        }
                    }
                });

                salirButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        formularioAlumnoFrame.dispose(); // Cierra el formulario de alumno
                    }
                });

                formularioAlumnoFrame.add(new JLabel("DNI:"));
                formularioAlumnoFrame.add(dniField);
                formularioAlumnoFrame.add(buscarButton);
                formularioAlumnoFrame.add(new JLabel("Apellido:"));
                formularioAlumnoFrame.add(apellidoField);
                formularioAlumnoFrame.add(new JLabel("Nombre:"));
                formularioAlumnoFrame.add(nombreField);
                formularioAlumnoFrame.add(new JLabel("Fecha de Nacimiento:"));
                formularioAlumnoFrame.add(fechaNacField);
                formularioAlumnoFrame.add(new JLabel("Estado:"));
                formularioAlumnoFrame.add(estadoField);
                formularioAlumnoFrame.add(nuevoButton);
                formularioAlumnoFrame.add(eliminarButton);
                formularioAlumnoFrame.add(guardarButton);
                formularioAlumnoFrame.add(salirButton);

                formularioAlumnoFrame.pack();
                formularioAlumnoFrame.setVisible(true);
            }
        });

        JMenu materiaMenu = new JMenu("Materia");
        JMenuItem materiaSubMenu = new JMenuItem("Formulario de Materia");
        materiaSubMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la nueva ventana del formulario de materia
                JFrame formularioMateriaFrame = new JFrame("Formulario de Materia");
                formularioMateriaFrame.setLayout(new GridLayout(6, 2));

                JTextField codigoField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField añoField = new JTextField();
                JRadioButton estadoField = new JRadioButton();

                JButton nuevoButton = new JButton("Nuevo");
                JButton eliminarButton = new JButton("Eliminar");
                JButton guardarButton = new JButton("Guardar");
                JButton buscarButton = new JButton("Buscar");
                JButton salirButton = new JButton("Salir");

                nuevoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        codigoField.setText("");
                        nombreField.setText("");
                        añoField.setText("");
                        estadoField.setSelected(false);
                    }
                });

                eliminarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = codigoField.getText();
                        if (!codigo.isEmpty()) {
                            // Llamar a la función para eliminar la materia por código
                            // Implementa la lógica en AlumnoData
                            AlumnoData materiaData = new AlumnoData();
                            // materiaData.eliminarMateriaPorCodigo(codigo);
                            JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
                            nuevoButton.doClick(); // Limpia los campos después de eliminar
                        }
                    }
                });

                guardarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = codigoField.getText();
                        String nombre = nombreField.getText();
                        int año = Integer.parseInt(añoField.getText());
                        boolean activa = estadoField.isSelected();

                        // Crear una instancia de Materia con los datos
                        // Asegúrate de tener la clase Materia definida
                        // Materia materia = new Materia(codigo, nombre, año, activa);
                        // Llamar a la función para guardar la materia
                        // Implementa la lógica en AlumnoData
                        // AlumnoData materiaData = new AlumnoData();
                        // materiaData.guardarMateria(materia);
                        JOptionPane.showMessageDialog(null, "Materia guardada correctamente");
                    }
                });

                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = codigoField.getText();
                        if (!codigo.isEmpty()) {
                            // Llamar a la función para buscar la materia por código
                            // Implementa la lógica en AlumnoData
                            // AlumnoData materiaData = new AlumnoData();
                            // Materia materia = materiaData.buscarMateriaPorCodigo(codigo);
                            // Actualizar los campos con los datos de la materia encontrada
                            // if (materia != null) {
                            //     nombreField.setText(materia.getNombre());
                            //     añoField.setText(String.valueOf(materia.getAño()));
                            //     estadoField.setSelected(materia.isActiva());
                            // }
                        }
                    }
                });

                salirButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        formularioMateriaFrame.dispose(); // Cierra el formulario de materia
                    }
                });

                formularioMateriaFrame.add(new JLabel("Código:"));
                formularioMateriaFrame.add(codigoField);
                formularioMateriaFrame.add(buscarButton);
                formularioMateriaFrame.add(new JLabel("Nombre:"));
                formularioMateriaFrame.add(nombreField);
                formularioMateriaFrame.add(new JLabel("Año:"));
                formularioMateriaFrame.add(añoField);
                formularioMateriaFrame.add(new JLabel("Estado:"));
                formularioMateriaFrame.add(estadoField);
                formularioMateriaFrame.add(nuevoButton);
                formularioMateriaFrame.add(eliminarButton);
                formularioMateriaFrame.add(guardarButton);
                formularioMateriaFrame.add(salirButton);

                formularioMateriaFrame.pack();
                formularioMateriaFrame.setVisible(true);
            }
        });

        JMenu administracionMenu = new JMenu("Administración");
        JMenuItem manejoInscripcionesSubMenu = new JMenuItem("Manejo de inscripciones");
        JMenuItem manipulacionNotasSubMenu = new JMenuItem("Manipulación de notas");

        manejoInscripcionesSubMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para el manejo de inscripciones
            }
        });

        manipulacionNotasSubMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para la manipulación de notas
            }
        });

        administracionMenu.add(manejoInscripcionesSubMenu);
        administracionMenu.add(manipulacionNotasSubMenu);

        JMenu consultasMenu = new JMenu("Consultas");
        JMenuItem alumnosPorMateriaSubMenu = new JMenuItem("Alumnos por materia");

        alumnosPorMateriaSubMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para consultar alumnos por materia
            }
        });

        consultasMenu.add(alumnosPorMateriaSubMenu);

        JMenu salirMenu = new JMenu("Salir");

        alumnoMenu.add(alumnoSubMenu);
        materiaMenu.add(materiaSubMenu);
        menuBar.add(alumnoMenu);
        menuBar.add(materiaMenu);
        menuBar.add(administracionMenu);
        menuBar.add(consultasMenu);
        menuBar.add(salirMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
