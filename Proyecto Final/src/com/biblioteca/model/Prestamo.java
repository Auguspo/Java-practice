package com.biblioteca.model;

import java.sql.Date;

public class Prestamo {

    private int ID;
    private String lectorDNI;
    private int ejemplarID;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private Ejemplar ejemplar;
    private String isbn; // Nuevo campo para el ISBN

    public Prestamo() {
        // Constructor sin argumentos
    }

    // Constructor modificado para incluir el ISBN
    public Prestamo(int id, String lectorDNI, int ejemplarID, Date fechaPrestamo, Date fechaDevolucion, String estado, String isbn) {
        this.ID = id;
        this.lectorDNI = lectorDNI;
        this.ejemplarID = ejemplarID;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.isbn = isbn; // Establecer el ISBN
    }

    // Getters y setters para cada atributo
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLectorDNI() {
        return lectorDNI;
    }

    public void setLectorDNI(String lectorDNI) {
        this.lectorDNI = lectorDNI;
    }

    public int getEjemplarID() {
        return ejemplarID;
    }

    public void setEjemplarID(int ejemplarID) {
        this.ejemplarID = ejemplarID;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }
  public String toString() {
        return String.format("ID: %d, Lector: %s, Ejemplar: %d, ISBN: %s, Estado: %s",
                getID(), getLectorDNI(), getEjemplarID(), getISBN(), getEstado());
    }
}
