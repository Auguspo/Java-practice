package Ej4;


public class Jugador {

    private int id;

    private String nombre;

    private boolean mojado;

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.mojado = false;
    }

    public void disparo(RevolverAgua revolver) {
        revolver.siguienteChorro();
        if (revolver.mojar()) {
            mojado = true;
        }
    }

    public boolean estaMojado() {
        return mojado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
}
