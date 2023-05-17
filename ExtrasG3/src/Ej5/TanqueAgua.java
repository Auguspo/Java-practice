package Ej5;

public class TanqueAgua {

    private int capacidadMaxima = 10000;

    private int capacidadActual;

    public TanqueAgua(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public boolean estaLleno() {
        return getCapacidadActual() == capacidadMaxima;
    }

    public boolean estaVacio() {
        return getCapacidadActual() == 0;
    }

    public void cargar(int carga) {
        if (!estaLleno()) {
            capacidadActual += carga;
            if (getCapacidadActual() > capacidadMaxima) {
                capacidadActual = capacidadMaxima;
            }
        }
    }

    public void consumir(int cantidad) {
        if (!estaVacio()) {
            capacidadActual -= cantidad;
            if (capacidadActual < 0) {
                capacidadActual = 0;
            }
        }
    }

    /**
     * @return the capacidadActual
     */
    public int getCapacidadActual() {
        return capacidadActual;
    }
}
