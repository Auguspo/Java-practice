package guia2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.Set;
import java.util.TreeSet;

public class EJ4 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Estructura de datos para almacenar productos
        Set<Producto> productosSet = new TreeSet<>();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Código");
        tableModel.addColumn("Descripción");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Stock");

        JMenuBar menuBar = new JMenuBar();
        JMenu administracionMenu = new JMenu("Administración");
        JMenuItem productosMenu = new JMenuItem("Productos");

        JMenu consultasMenu = new JMenu("Consultas");
        JMenuItem porRubroMenu = new JMenuItem("Por Rubro");
        JMenuItem porNombreMenu = new JMenuItem("Por Nombre");
        JMenuItem porPrecioMenu = new JMenuItem("Por Precio");

        menuBar.add(administracionMenu);
        menuBar.add(consultasMenu);
        administracionMenu.add(productosMenu);
        consultasMenu.add(porRubroMenu);
        consultasMenu.add(porNombreMenu);
        consultasMenu.add(porPrecioMenu);

        productosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame productosFrame = new JFrame("Gestión de Productos");
                productosFrame.setSize(400, 300);
                productosFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new Insets(5, 5, 5, 5);

                JLabel codigoLabel = new JLabel("Código:");
                JTextField codigoField = new JTextField(10);

                JButton buscarButton = new JButton("Buscar");

                JLabel descripcionLabel = new JLabel("Descripción:");
                JTextField descripcionField = new JTextField(10);

                JLabel precioLabel = new JLabel("Precio:");
                JTextField precioField = new JTextField(10);

                JLabel rubroLabel = new JLabel("Rubro:");
                String[] rubroOptions = {"Comestible", "Limpieza", "Perfumería"};
                JComboBox<String> rubroComboBox = new JComboBox<>(rubroOptions);

                JLabel stockLabel = new JLabel("Stock:");
                JTextField stockField = new JTextField(10);

                JButton nuevoButton = new JButton("Nuevo");
                JButton guardarButton = new JButton("Guardar");
                JButton eliminarButton = new JButton("Eliminar");
                JButton salirButton = new JButton("Salir");

                gbc.gridx = 0;
                gbc.gridy = 0;
                panel.add(codigoLabel, gbc);

                gbc.gridx = 1;
                panel.add(codigoField, gbc);

                gbc.gridx = 2;
                panel.add(buscarButton, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                panel.add(descripcionLabel, gbc);

                gbc.gridx = 1;
                panel.add(descripcionField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                panel.add(precioLabel, gbc);

                gbc.gridx = 1;
                panel.add(precioField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                panel.add(rubroLabel, gbc);

                gbc.gridx = 1;
                panel.add(rubroComboBox, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                panel.add(stockLabel, gbc);

                gbc.gridx = 1;
                panel.add(stockField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                panel.add(nuevoButton, gbc);

                gbc.gridx = 1;
                panel.add(guardarButton, gbc);

                gbc.gridx = 2;
                panel.add(eliminarButton, gbc);

                gbc.gridx = 3;
                panel.add(salirButton, gbc);

                productosFrame.add(panel);
                productosFrame.setVisible(true);

                // Nuevo Button: Para crear un nuevo producto
                nuevoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Limpiar los campos de entrada
                        codigoField.setText("");
                        descripcionField.setText("");
                        precioField.setText("");
                        rubroComboBox.setSelectedIndex(0);
                        stockField.setText("");
                    }
                });

                // Guardar Button: Para guardar un producto
                guardarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String descripcion = descripcionField.getText();
                            double precio = Double.parseDouble(precioField.getText());
                            String rubro = rubroComboBox.getSelectedItem().toString();
                            int stock = Integer.parseInt(stockField.getText());

                            // Crear un objeto Producto y agregarlo al TreeSet
                            Producto producto = new Producto(codigo, descripcion, precio, rubro, stock);
                            productosSet.add(producto);

                            // Agregar el producto a la tabla
                            tableModel.addRow(new Object[]{codigo, descripcion, precio, stock});

                            // Limpiar los campos
                            codigoField.setText("");
                            descripcionField.setText("");
                            precioField.setText("");
                            rubroComboBox.setSelectedIndex(0);
                            stockField.setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para Precio y Stock", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Eliminar Button: Para eliminar un producto
                eliminarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int codigo = Integer.parseInt(codigoField.getText());

                        // Eliminar el producto del TreeSet y de la tabla
                        for (Producto producto : productosSet) {
                            if (producto.getCodigo() == codigo) {
                                productosSet.remove(producto);
                                int rowToDelete = -1;
                                for (int i = 0; i < tableModel.getRowCount(); i++) {
                                    if ((int) tableModel.getValueAt(i, 0) == codigo) {
                                        rowToDelete = i;
                                        break;
                                    }
                                }
                                if (rowToDelete >= 0) {
                                    tableModel.removeRow(rowToDelete);
                                }
                                break;
                            }
                        }

                        // Limpiar el campo de código
                        codigoField.setText("");
                        descripcionField.setText("");
                        precioField.setText("");
                        rubroComboBox.setSelectedIndex(0);
                        stockField.setText("");
                    }
                });
                salirButton.addActionListener((ActionEvent e1) -> {
                    productosFrame.dispose();
                });
                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!codigoField.getText().isEmpty()) {
                            int codigo = Integer.parseInt(codigoField.getText());

                            boolean productoEncontrado = false;
                            for (Producto producto : productosSet) {
                                if (producto.getCodigo() == codigo) {
                                    // Rellenar los campos con los datos del producto encontrado
                                    descripcionField.setText(producto.getDescripcion());
                                    precioField.setText(Double.toString(producto.getPrecio()));
                                    rubroComboBox.setSelectedItem(producto.getRubro());
                                    stockField.setText(Integer.toString(producto.getStock()));
                                    productoEncontrado = true;
                                    break; // Salir del bucle una vez que se encuentre el producto
                                }
                            }

                            if (!productoEncontrado) {
                                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{JOptionPane.showMessageDialog(null, "Codigo Vacio", "Error", JOptionPane.ERROR_MESSAGE);}
                    }
                });
            }

        });

        porRubroMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame rubroFrame = new JFrame("Lista de Productos por Rubro");
                rubroFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                rubroFrame.setLayout(new BorderLayout());

                JPanel topPanel = new JPanel();
                JComboBox<String> rubroComboBox = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Perfumería"});
                topPanel.add(rubroComboBox);
                JButton consultarButton = new JButton("Consultar");
                topPanel.add(consultarButton);

                rubroFrame.add(topPanel, BorderLayout.NORTH);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Código");
                model.addColumn("Descripción");
                model.addColumn("Precio");
                model.addColumn("Stock");

                JTable productTable = new JTable(model);
                JScrollPane tableScrollPane = new JScrollPane(productTable);
                rubroFrame.add(tableScrollPane, BorderLayout.CENTER);
                tableScrollPane.setBounds(10, 100, 480, 150);

                rubroFrame.setSize(800, 600);
                rubroFrame.setVisible(true);

                // Consultar Button: Para filtrar productos por rubro
                consultarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedRubro = rubroComboBox.getSelectedItem().toString();
                        model.setRowCount(0); // Limpiar la tabla

                        for (Producto producto : productosSet) {
                            if (producto.getRubro().equals(selectedRubro)) {
                                model.addRow(new Object[]{producto.getCodigo(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()});
                            }
                        }
                    }
                });
            }
        });

        porNombreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame nombreFrame = new JFrame("Lista de Productos por Nombre");
                nombreFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                nombreFrame.setLayout(new BorderLayout());

                JPanel topPanel = new JPanel();
                JLabel nombreLabel = new JLabel("Escriba los primeros caracteres:");
                JTextField nombreField = new JTextField(10);
                JButton consultarButton = new JButton("Consultar");

                topPanel.add(nombreLabel);
                topPanel.add(nombreField);
                topPanel.add(consultarButton);
                nombreFrame.add(topPanel, BorderLayout.NORTH);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Código");
                model.addColumn("Descripción");
                model.addColumn("Precio");
                model.addColumn("Stock");

                JTable productTable = new JTable(model);
                JScrollPane tableScrollPane = new JScrollPane(productTable);
                nombreFrame.add(tableScrollPane, BorderLayout.CENTER);

                nombreFrame.setSize(800, 600);
                nombreFrame.setVisible(true);

                // Consultar Button: Para filtrar productos por nombre
                consultarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String searchString = nombreField.getText();
                        model.setRowCount(0); // Limpiar la tabla

                        for (Producto producto : productosSet) {
                            if (producto.getDescripcion().toLowerCase().contains(searchString.toLowerCase())) {
                                model.addRow(new Object[]{producto.getCodigo(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()});
                            }
                        }
                    }
                });
            }
        });

        porPrecioMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame precioFrame = new JFrame("Lista de Productos por Precio");
                precioFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                precioFrame.setLayout(new BorderLayout());

                JPanel topPanel = new JPanel();
                JLabel precioLabel1 = new JLabel("Entre $");
                JTextField precioField1 = new JTextField(10);
                JLabel precioLabel2 = new JLabel(" y ");
                JTextField precioField2 = new JTextField(10);
                JButton consultarButton = new JButton("Consultar");

                topPanel.add(precioLabel1);
                topPanel.add(precioField1);
                topPanel.add(precioLabel2);
                topPanel.add(precioField2);
                topPanel.add(consultarButton);
                precioFrame.add(topPanel, BorderLayout.NORTH);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Código");
                model.addColumn("Descripción");
                model.addColumn("Precio");
                model.addColumn("Stock");

                JTable productTable = new JTable(model);
                JScrollPane tableScrollPane = new JScrollPane(productTable);
                precioFrame.add(tableScrollPane, BorderLayout.CENTER);

                precioFrame.setSize(800, 600);
                precioFrame.setVisible(true);

                // Consultar Button: Para filtrar productos por rango de precio
                consultarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        double minPrice = Double.parseDouble(precioField1.getText());
                        double maxPrice = Double.parseDouble(precioField2.getText());
                        model.setRowCount(0); // Limpiar la tabla

                        for (Producto producto : productosSet) {
                            if (producto.getPrecio() >= minPrice && producto.getPrecio() <= maxPrice) {
                                model.addRow(new Object[]{producto.getCodigo(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()});
                            }
                        }
                    }
                });
            }
        });

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}

class Producto implements Comparable<Producto> {

    private int codigo;
    private String descripcion;
    private double precio;
    private String rubro;
    private int stock;

    public Producto(int codigo, String descripcion, double precio, String rubro, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rubro = rubro;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getRubro() {
        return rubro;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Integer.compare(this.codigo, otroProducto.codigo);
    }
}
