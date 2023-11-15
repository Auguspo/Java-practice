/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliote.data;

import com.biblioteca.model.Lector;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NO ICE
 */
public class LectorData {

    private Connection con = null;

    public LectorData() {
        try {
            con = ConexionBD.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemplarData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarLector(Lector lector) {
    }

    public void borrarLector(Lector lector) {
    }

    public void modificarLector(Lector lector) {
    }

    public Lector buscarLectorPorNroSocio(Lector lector) {
        return null;
    }

    public List<Lector> listarLectores(Lector lector) {
        return null;
    }

}
