/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliote.data;

import com.biblioteca.model.Lector;
import com.biblioteca.model.Prestamo;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NO ICE
 */
public class PrestamoData {

    private Connection con;

    public PrestamoData() {
        try {
            con = ConexionBD.getConexion();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemplarData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarPrestamo(Prestamo prestamo){}
    
    public void modificarPrestamos(Prestamo prestamo){}
    
    public void borrarPrestamo(Prestamo prestamo){}
    
    public List<Prestamo> buscarPrestamoPorEstado(String estado){
        return null;
    }
    
    public Lector buscarPrestamoPorLector(String lector){
        return null;
    }
    
    
    
    
    
}
