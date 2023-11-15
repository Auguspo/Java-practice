package com.biblioteca.model;

public class Lector {

    private int nroSocio;

    private String nombre;

    private Object domicilio;

    private String mail;

    private boolean estado;

    public Lector(String nombre, Object domicilio, String mail, boolean estado) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }

    public int getNroSocio() {
        return nroSocio;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Object domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
