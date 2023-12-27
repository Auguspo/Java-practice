package com.biblioteca.model;

public class Ejemplar {

    private int ID;
    private String libroISBN;
    private String estado;

    public Ejemplar() {
        // Constructor sin argumentos
    }
    private Libro libro;

    public Ejemplar(int ID, String libroISBN, String estado) {
        this.ID = ID;
        this.libroISBN = libroISBN;
        this.estado = estado;
    }
  public Ejemplar(String libroISBN, String estado) {
        this.libroISBN = libroISBN;
        this.estado = estado;
         // Valor por defecto, indica que se generará automáticamente al guardar en la base de datos
    }
    // Getters y setters para cada atributo
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLibroISBN() {
        return libroISBN;
    }

    public void setLibroISBN(String libroISBN) {
        this.libroISBN = libroISBN;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

      @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + ID +
                ", libroISBN='" + libroISBN + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
