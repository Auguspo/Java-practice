package extrag2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NOICE
 */
public class GestionContactosApp {

    public class Contacto {

        private String nombre;
        private String telefono;
        private String email;

        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }

        // Getters y setters para los campos
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
        }
    }

    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    private DefaultTableModel tableModel;

    public GestionContactosApp() {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Contactos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Crear paneles para organizar componentes
        JPanel panelDatos = new JPanel(new GridLayout(3, 2));
        JPanel panelBotones = new JPanel(new FlowLayout());

        // Crear campos de entrada
        JTextField nombreField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField emailField = new JTextField();

        // Crear etiquetas para los campos
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel telefonoLabel = new JLabel("Teléfono:");
        JLabel emailLabel = new JLabel("Email:");

        // Crear botones
        JButton agregarButton = new JButton("Agregar Contacto");
        JButton buscarButton = new JButton("Buscar Contacto");
        JButton actualizarButton = new JButton("Actualizar");

        // Agregar el botón a la ventana
        panelBotones.add(actualizarButton);

        // Manejar el evento de clic en el botón "Actualizar"
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualiza la tabla con la lista de contactos
                actualizarTabla();
            }
        });
        // Crear una tabla para mostrar los contactos
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Email");

        JTable contactTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(contactTable);

        // Agregar componentes a los paneles
        panelDatos.add(nombreLabel);
        panelDatos.add(nombreField);
        panelDatos.add(telefonoLabel);
        panelDatos.add(telefonoField);
        panelDatos.add(emailLabel);
        panelDatos.add(emailField);

        panelBotones.add(agregarButton);
        panelBotones.add(buscarButton);

        // Agregar paneles a la ventana principal
        frame.add(panelDatos, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.CENTER);
        frame.add(tableScrollPane, BorderLayout.SOUTH);

        // Manejar el evento de agregar contacto
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String email = emailField.getText();

                Contacto contacto = new Contacto(nombre, telefono, email);
                listaContactos.add(contacto);

                // Limpia los campos después de agregar el contacto
                nombreField.setText("");
                telefonoField.setText("");
                emailField.setText("");

                // Actualiza la tabla
                actualizarTabla();
            }
        });

        // Manejar el evento de buscar contacto
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = nombreField.getText();

                // Limpia la tabla antes de mostrar los resultados de la búsqueda
                tableModel.setRowCount(0);

                for (Contacto contacto : listaContactos) {
                    if (contacto.getNombre().contains(busqueda)) {
                        tableModel.addRow(new Object[]{contacto.getNombre(), contacto.getTelefono(), contacto.getEmail()});
                    }
                }
            }
        });

        // Mostrar la ventana principal
        frame.setVisible(true);
    }

    // Función para actualizar la tabla con los contactos
    private void actualizarTabla() {
        tableModel.setRowCount(0);
        for (Contacto contacto : listaContactos) {
            tableModel.addRow(new Object[]{contacto.getNombre(), contacto.getTelefono(), contacto.getEmail()});
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionContactosApp();
            }
        });
    }
  

 

}
