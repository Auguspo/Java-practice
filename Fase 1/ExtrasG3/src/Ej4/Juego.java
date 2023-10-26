package Ej4;


public class Juego {

 private Jugador jugador1;
    private Jugador jugador2;
    private RevolverAgua revolver;

    public void llenarJuego(Jugador jugador1, Jugador jugador2, RevolverAgua revolver) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.revolver = revolver;
    }


    public void ronda() {
        while (true) {
            Jugador jugadorActual = obtenerJugadorActual();
            System.out.println(jugadorActual + " se apunta con el revolver y aprieta el gatillo...");
            jugadorActual.disparo(revolver);

            if (jugadorActual.estaMojado()) {
                System.out.println(jugadorActual + " se ha mojado. ¡Fin del juego!");
                break;
            } else {
                System.out.println(jugadorActual + " se ha salvado. Siguiente ronda.");
            }
        }

    }

    public Jugador obtenerJugadorActual() {
        if (jugador1.estaMojado()) {
            return jugador2;
        } else {
            return jugador1;
        }
    }


}
