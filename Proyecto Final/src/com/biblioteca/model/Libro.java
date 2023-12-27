package com.biblioteca.model;

public class Libro {

    private String ISBN;
    private String nombre;
    private String genero;
    private String editorial;
    private String autor;
    private String estado;
    private int cantidad;

    public Libro() {
        // Constructor sin argumentos
    }

    public Libro(String ISBN, String nombre, String genero, String editorial, String autor, String estado, int cantidad) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.genero = genero;
        this.editorial = editorial;
        this.autor = autor;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", ISBN, nombre);
    }

    // Getters y setters para cada atributo
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
