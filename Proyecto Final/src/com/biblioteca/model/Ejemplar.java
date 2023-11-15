package com.biblioteca.model;

public class Ejemplar {

    public Ejemplar(int codigo, Libro libro, boolean estado, int cantidad) {
        this.codigo = codigo;
        this.libro = libro;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    private int codigo;

    private Libro libro;
    private int cantidad ;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private boolean estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
