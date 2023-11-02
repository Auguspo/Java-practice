package universidadejemplo.Entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NOICE
 */
public class Materia {

    @Override
    public String toString() {
        return "ID de Materia: " + idMateria
                + "\nNombre: " + nombre
                + "\nAño de Materia: " + anioMateria
                + "\nActivo: " + (activo ? "Sí" : "No");
    }

    public Materia() {
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public Materia(int idMateria, String nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anioMateria
     */
    public int getAnioMateria() {
        return anioMateria;
    }

    /**
     * @param anioMateria the anioMateria to set
     */
    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private int idMateria;
    private String nombre;
    private int anioMateria;
    private boolean activo;
}
