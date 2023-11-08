package universidadejemplo.Vistas.Materias;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import universidadejemplo.Entidades.Materia;

public class MateriaList {
    private JPanel mainPanel;
    private JTable materiasTable;
    private JButton actualizarButton;
    private JButton volverButton;

    private DefaultTableModel tableModel;

    public MateriaList() {
        mainPanel = new JPanel(new BorderLayout());

        actualizarButton = new JButton("Actualizar Lista");
        volverButton = new JButton("Volver");

        // Botón para actualizar la lista de materias
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Materia> materias = obtenerMateriasDesdeBD(); // Obtener la lista de materias desde la base de datos
                // Actualizar la tabla con la lista de materias
                actualizarTabla(materias);
            }
        });

        // Botón para volver a la ventana principal u otra acción de salida
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar esta ventana o realizar otra acción de salida
            }
        });

        // Crear un modelo de tabla con las columnas Código, Nombre y Año
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Código");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Año");
        materiasTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(materiasTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(actualizarButton);
        buttonPanel.add(volverButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private List<Materia> obtenerMateriasDesdeBD() {
        // Lógica para obtener la lista de materias desde la base de datos
        // ...

        return null; // Reemplazar esto con la lista real de materias
    }

    private void actualizarTabla(List<Materia> materias) {
        // Limpiar la tabla antes de actualizar
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        // Agregar los datos de las materias al modelo de tabla
        for (Materia materia : materias) {
            Object[] rowData = {materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Materias");
        MateriaList materiaLista = new MateriaList();
        frame.add(materiaLista.getMainPanel());
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
