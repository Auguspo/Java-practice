package com.biblioteca.ui;

import com.biblioteca.data.EjemplarData;
import com.biblioteca.data.LectorData;
import com.biblioteca.data.LibroData;
import com.biblioteca.data.PrestamoData;
import javax.swing.*;

public class BibliotecaUI extends JFrame {

    private LibroData libroData;
    private EjemplarData ejemplarData;
    private LectorData lectorData;
    private PrestamoData prestamoData;

    public BibliotecaUI() {
        libroData = new LibroData();
        ejemplarData = new EjemplarData();
        lectorData = new LectorData();
        prestamoData = new PrestamoData();

        setTitle("Gestión de Biblioteca");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Libros", new LibroPanel(libroData));
        tabbedPane.addTab("Ejemplares", new EjemplarPanel(ejemplarData, libroData));
        tabbedPane.addTab("Lectores", new LectorPanel(lectorData));
        tabbedPane.addTab("Prestamos", new PrestamoPanel(prestamoData, libroData.obtenerTodosLosLibros(), lectorData.obtenerTodosLosLectores()));

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BibliotecaUI();
            }
        });
    }
}
