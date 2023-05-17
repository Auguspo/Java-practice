package Ej5;

public class Bomba {

    private Motor motor;

    public Bomba(Motor motor) {
        this.motor = motor;
    }

    public void regar() {
        while (!motor.getTanque().estaVacio()) {
            motor.consumirAgua();
        }
    }

    public void mostrarInfor() {
        System.out.println("Carga inicial del tanque: " + motor.getTanque().getCapacidadActual() + " litros");
        System.out.println("Velocidad del motor: " + motor.getVelocidad());
    }
}
