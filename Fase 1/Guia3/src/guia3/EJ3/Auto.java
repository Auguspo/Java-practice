/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia3.EJ3;

/**
 *
 * @author NO ICE
 */
public class Auto {
    private String color;
    private String patente;
    private int combustible;
    private Rueda ruedas[];

    public Auto(String color, String patente) {
        this.color = color;
        this.patente = patente;
        this.combustible = 50;
        this.ruedas = new Rueda[4];
        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i] = new Rueda();
        }
    }

    public void avanzar(int metros) {
        int consumo = metros / 10;
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println("Avanzando " + metros + " metros...");
        } else {
            System.out.println("No hay combustible suficiente para avanzar.");
        }
    }

    public void retroceder(int metros) {
        int consumo = metros / 10;
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println("Retrocediendo " + metros + " metros...");
        } else {
            System.out.println("No hay combustible suficiente para retroceder.");
        }
    }

    public void llenarTanque() {
        combustible = 50;
        System.out.println("Llenando el tanque...");
    }

    public void inflarRuedas() {
        for (Rueda rueda : ruedas) {
            rueda.inflar();
        }
    }

    public void desinflarRuedas() {
        for (Rueda rueda : ruedas) {
            rueda.desinflar();
        }
    }
}




