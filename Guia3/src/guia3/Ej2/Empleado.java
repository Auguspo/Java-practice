/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej2;
import java.util.Date;

/**
 *
 * @author NOICE
 */
public class Empleado {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    
    
    public Empleado(String nombre, String apellido, Date fechaIngreso, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.dni = dni;
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
}