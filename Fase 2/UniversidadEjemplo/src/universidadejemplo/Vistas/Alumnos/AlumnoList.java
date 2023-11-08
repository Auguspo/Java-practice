package universidadejemplo.Vistas.Alumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.Entidades.Alumno;

public class AlumnoList {
    private JPanel mainPanel;
    private JTable alumnosTable;
    private JButton actualizarButton;
    private JButton volverButton;

    private DefaultTableModel tableModel;
    private AlumnoData alumnoData;

    public AlumnoList() {
        mainPanel = new JPanel(new BorderLayout());

        alumnoData = new AlumnoData();
        actualizarButton = new JButton("Actualizar Lista");
        volverButton = new JButton("Volver");

        // Botón para actualizar la lista de alumnos
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Alumno> alumnos = alumnoData.listarAlumnos();
                // Actualizar la tabla con la lista de alumnos
                actualizarTabla(alumnos);
            }
        });

        // Botón para volver a la ventana principal u otra acción de salida
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar esta ventana o realizar otra acción de salida
            }
        });

        // Crear un modelo de tabla con las columnas DNI, Apellido y Nombre
        tableModel = new DefaultTableModel();
        tableModel.addColumn("DNI");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Nombre");
        alumnosTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(alumnosTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(actualizarButton);
        buttonPanel.add(volverButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void actualizarTabla(List<Alumno> alumnos) {
        // Limpiar la tabla antes de actualizar
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        // Agregar los datos de los alumnos al modelo de tabla
        for (Alumno alumno : alumnos) {
            Object[] rowData = {alumno.getDni(), alumno.getApellido(), alumno.getNombre()};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Alumnos");
        AlumnoList alumnoList = new AlumnoList();
        frame.add(alumnoList.getMainPanel());
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
