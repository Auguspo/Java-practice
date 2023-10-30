package extrag2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaDeTareasApp extends JFrame {
    private DefaultListModel<String> pendientesModel;
    private DefaultListModel<String> completadasModel;
    private JList<String> pendientesList;
    private JList<String> completadasList;
    private JButton agregarTareaButton;
    private JButton borrarTareaButton;
    private JButton completarTareaButton;

    private ArrayList<String> tareasPendientes = new ArrayList<>();
    private ArrayList<String> tareasCompletadas = new ArrayList<>();

    public ListaDeTareasApp() {
        setTitle("Lista de Tareas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(1, 3));

        pendientesModel = new DefaultListModel<>();
        completadasModel = new DefaultListModel<>();

        pendientesList = new JList<>(pendientesModel);
        completadasList = new JList<>(completadasModel);

        agregarTareaButton = new JButton("Agregar Tarea");
        borrarTareaButton = new JButton("Borrar Tarea");
        completarTareaButton = new JButton("Completar Tarea");

        agregarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaNuevaTarea();
            }
        });

        borrarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = pendientesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tareasPendientes.remove(selectedIndex);
                    pendientesModel.remove(selectedIndex);
                }
            }
        });

        completarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = pendientesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String tareaCompletada = tareasPendientes.get(selectedIndex);
                    tareasCompletadas.add(tareaCompletada);
                    completadasModel.addElement(tareaCompletada);
                    tareasPendientes.remove(selectedIndex);
                    pendientesModel.remove(selectedIndex);
                }
            }
        });

        JPanel pendientesPanel = new JPanel();
        pendientesPanel.setLayout(new BorderLayout());
        pendientesPanel.add(new JLabel("Tareas Pendientes"), BorderLayout.NORTH);
        pendientesPanel.add(new JScrollPane(pendientesList), BorderLayout.CENTER);
        pendientesPanel.add(borrarTareaButton, BorderLayout.SOUTH);

        JPanel completadasPanel = new JPanel();
        completadasPanel.setLayout(new BorderLayout());
        completadasPanel.add(new JLabel("Tareas Completadas"), BorderLayout.NORTH);
        completadasPanel.add(new JScrollPane(completadasList), BorderLayout.CENTER);
        completadasPanel.add(completarTareaButton, BorderLayout.SOUTH);

        JPanel botonesPanel = new JPanel();  // Panel para los botones
        botonesPanel.setLayout(new FlowLayout());  // Diseño de flujo para alinear los botones
        botonesPanel.add(agregarTareaButton);  // Agrega el botón "Agregar Tarea"

        add(pendientesPanel);
        add(completadasPanel);
        add(botonesPanel);  // Agrega el panel de botones a la ventana principal
    }

    private void abrirVentanaNuevaTarea() {
        JDialog dialog = new JDialog(this, "Agregar Nueva Tarea", true);
        dialog.setLayout(new BorderLayout());
        JTextField nuevaTareaField = new JTextField();
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaTarea = nuevaTareaField.getText();
                if (!nuevaTarea.isEmpty()) {
                    tareasPendientes.add(nuevaTarea);
                    pendientesModel.addElement(nuevaTarea);
                    dialog.dispose();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Nueva Tarea"), BorderLayout.NORTH);
        panel.add(nuevaTareaField, BorderLayout.CENTER);
        panel.add(agregarButton, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListaDeTareasApp app = new ListaDeTareasApp();
                app.setVisible(true);
            }
        });
    }
}
