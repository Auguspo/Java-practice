package Ej4;


import java.util.Random;

public class RevolverAgua {

    private int posicionActual;

    private int posicionAgua;

    public void llenarRevolver() {
        Random random = new Random();
        posicionActual = random.nextInt(6); // Se generan números aleatorios entre 0 y 5
        posicionAgua = random.nextInt(6);
    }

    public boolean mojar() {
        return (posicionActual == posicionAgua);
    }

    public void siguienteChorro() {
        posicionActual = (posicionActual + 1) % 6;
    }

    public String aTexto() {
        return "Revolver de agua -> Posición actual: " + posicionActual + " | Posición del agua: " + posicionAgua;
    }



}
