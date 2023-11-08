package universidadejemplo.Vistas.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import universidadejemplo.Vistas.Administracion.InscripcionForm;
import universidadejemplo.Vistas.Administracion.NotasForm;
import universidadejemplo.Vistas.Consultas.AlumnosPorMateria;
import universidadejemplo.Vistas.Materias.MateriaForm;

public class MainWindow {

    private JFrame mainFrame;
    private JPanel mainPanel;

    public MainWindow() {
        mainFrame = new JFrame("Gestión de universidad");
        mainFrame.setSize(600, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu alumnoMenu = new JMenu("Alumno");
        JMenuItem formularioAlumnoMenuItem = new JMenuItem("Formulario de Alumno");
        formularioAlumnoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formularioAlumnoFrame = new JFrame("Formulario de Alumno");
                formularioAlumnoFrame.setLayout(new GridLayout(7, 2));

                // Implementa la lógica del formulario de alumno aquí
                formularioAlumnoFrame.pack();
                formularioAlumnoFrame.setVisible(true);
            }
        });

        alumnoMenu.add(formularioAlumnoMenuItem);

        JMenu materiaMenu = new JMenu("Materia");
        JMenuItem formularioMateriaMenuItem = new JMenuItem("Formulario de Materia");
        formularioMateriaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formularioMateriaFrame = new JFrame("Formulario de Materia");
                MateriaForm materiaForm = new MateriaForm();
                formularioMateriaFrame.setLayout(new GridLayout(6, 2));

                formularioMateriaFrame.add(materiaForm.getMainPanel());
                // Implementa la lógica del formulario de materia aquí

                formularioMateriaFrame.pack();
                formularioMateriaFrame.setVisible(true);
            }
        });

        materiaMenu.add(formularioMateriaMenuItem);

        JMenu administracionMenu = new JMenu("Administración");
        JMenuItem inscripcionMenuItem = new JMenuItem("Inscripción");
        inscripcionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inscripcionFrame = new JFrame("Formulario de Inscripción");
                InscripcionForm inscripcionForm = new InscripcionForm();
                inscripcionFrame.add(inscripcionForm.getMainPanel());
                inscripcionFrame.pack();
                inscripcionFrame.setVisible(true);
            }
        });

        JMenuItem notasMenuItem = new JMenuItem("Notas");
        notasMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame notasFrame = new JFrame("Formulario de Notas");
                NotasForm notasForm = new NotasForm();
                notasFrame.add(notasForm.getMainPanel());
                notasFrame.pack();
                notasFrame.setVisible(true);
            }
        });

        administracionMenu.add(inscripcionMenuItem);
        administracionMenu.add(notasMenuItem);

        JMenu consultasMenu = new JMenu("Consultas");
        JMenuItem alumnosPorMateriaMenuItem = new JMenuItem("Alumnos por Materia");
        alumnosPorMateriaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame alumnosPorMateriaFrame = new JFrame("Consultar Alumnos por Materia");
                AlumnosPorMateria alumnosPorMateria = new AlumnosPorMateria();
                alumnosPorMateriaFrame.add(alumnosPorMateria.getMainPanel());
                alumnosPorMateriaFrame.pack();
                alumnosPorMateriaFrame.setVisible(true);
            }
        });

        consultasMenu.add(alumnosPorMateriaMenuItem);
        JMenu salirMenu = new JMenu("Salir");
        JMenuItem salirMenuItem = new JMenuItem("Salir del Programa");

        salirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Cierra la aplicación
                }
            }
        });

        menuBar.add(alumnoMenu);
        menuBar.add(materiaMenu);
        menuBar.add(administracionMenu);
        menuBar.add(consultasMenu);
        salirMenu.add(salirMenuItem);
        menuBar.add(salirMenu);

        mainFrame.setJMenuBar(menuBar);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
