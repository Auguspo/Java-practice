/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej4;

/**
 *
 * @author NOICE
 */
public class Robot {
    private int energia;
    private Bateria bateria;
    private boolean durmiendo;

    public Robot() {
        energia = 1000;
        bateria = new Bateria(1000);
        durmiendo = false;
    }

    public void avanzar(int pasos) {
        if (!durmiendo) {
            int perdidaEnergia = pasos / 100 * 10;
            energia -= perdidaEnergia;
            bateria.setCarga(bateria.getCarga() - perdidaEnergia);
        }
    }

    public void retroceder(int pasos) {
        if (!durmiendo) {
            int perdidaEnergia = pasos / 100 * 10;
            energia -= perdidaEnergia;
            bateria.setCarga(bateria.getCarga() - perdidaEnergia);
        }
    }
    
    public void dormir() {
        if(durmiendo == false){
        durmiendo = true;}
        else{System.out.println("Ya estoy durmiendo shh");}
    }

    public void despertar() {
        if(durmiendo == true){
        durmiendo = false;}
        else{System.out.println("Ya estoy despierto");}
    }

     public void recargar() {
        if(bateria.getCarga() < 1000){
            bateria.setCarga(1000);
            System.out.println("Carga completa");}
        else{System.out.println("Ya estoy cargado completamente");
        }
    }

    public boolean bateriaLLena() {
        return bateria.getCarga() == 1000;
    }

    public boolean bateriaVacia() {
        return bateria.getCarga() == 0;
    }

    public int energiaActual() {
        return energia;
    }
}
