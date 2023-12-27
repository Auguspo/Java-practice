package com.biblioteca.model;

public class Lector {
    private String DNI;
    private String nombre;
    private String domicilio;
    private String telefono;
    private boolean Estado;

    public Lector() {
        // Constructor sin argumentos
    }

    // Corregir el nombre del parámetro a 'estado'
    public Lector(String DNI, String nombre, String domicilio, String telefono, boolean estado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.Estado = estado;  // Asignar correctamente el valor del parámetro
    }

    // Getters y setters para cada atributo

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   public boolean isActivo() {
    return "Activo".equals(Estado);
}

    public void setActivo(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", DNI, nombre);
    }
}
