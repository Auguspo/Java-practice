/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliote.data;

import com.biblioteca.model.Libro;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NO ICE
 */
public class LibroData {

    private Connection con = null;

    public LibroData() {
        try {
            con = ConexionBD.getConexion();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemplarData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarLibro(Libro libro) {
    }

    public void borrarLibro(Libro libro) {
    }

    public void modificarLibro(Libro libro) {
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        return null;
    }

    public List<Libro> buscarLibroPorNombre(String libro) {return null;
    }

    public List<Libro> buscarLibroPorGenero(String libro) {return null;
    }

    public Libro buscarLibroPorISBN(String libro) {return null;
    }

}
