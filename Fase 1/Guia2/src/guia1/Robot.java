/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
 * @author NOICE
 */
public class Robot {
    private String nombre;
    private int bateria = 500;

    public Robot(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public void avanzar(int pasos) {
        int consumoBateria = pasos / 100 * 10;
        if (bateria >= consumoBateria) {
            bateria -= consumoBateria;
            System.out.println(nombre + " ha avanzado " + pasos + " pasos.");
        } else {
            System.out.println("No hay suficiente batería para avanzar.");
        }
    }
    
    public boolean bateriaVacia() {
         return bateria <= 0;
    }
}

