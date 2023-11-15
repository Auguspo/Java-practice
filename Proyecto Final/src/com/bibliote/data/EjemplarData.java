/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliote.data;

import com.biblioteca.model.Ejemplar;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NO ICE
 */
public class EjemplarData {

    private Connection con = null;

    public EjemplarData() {

        try {
            con = ConexionBD.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemplarData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarEjemplar(Ejemplar ejemplar) {
    }

    public void borrarEjemplar(Ejemplar ejemplar) {
    }

    public Ejemplar buscarEjemplarPorCodigo(String ejemplar) {
        return null;
    }

    public void modificarEjemplar(Ejemplar ejemplar) {
    }

    public List<Ejemplar> listarEjemplares() {
        return null;
    }

}
