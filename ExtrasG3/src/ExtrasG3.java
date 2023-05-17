/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4;

/**
 *
 * @author NOICE
 */
public class ExtrasG3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        Dado dado3 = new Dado();

        // b) Crear un Jugador de nombre “Pocho” y pedirle que tire los 3 Dados.
        Jugador pocho = new Jugador("Pocho");
        pocho.tirarDado(dado1);
        pocho.tirarDado(dado2);
        pocho.tirarDado(dado3);

        // c) Mostrar al final la clasificación del Jugador.
        System.out.println("Clasificación de " + pocho.getNombre() + ": " + pocho.verClasificacion());

        // d) Ahora Crear otros 3 Dados más.
        Dado dado4 = new Dado();
        Dado dado5 = new Dado();
        Dado dado6 = new Dado();

        // e) Crear un nuevo Jugador de nombre “Pepe” y pedirle que tire los 3 últimos dados creados.
        Jugador pepe = new Jugador("Pepe");
        pepe.tirarDado(dado4);
        pepe.tirarDado(dado5);
        pepe.tirarDado(dado6);
        System.out.println("Clasificación de " + pepe.getNombre() + ": " + pepe.verClasificacion());
        // f) Al finalizar mostrar de los 2 jugadores el nombre que obtuvo la mayor clasificación.
        int clasificacionPocho = pocho.verClasificacion();
        int clasificacionPepe = pepe.verClasificacion();

        if (clasificacionPocho > clasificacionPepe) {
            System.out.println("El ganador es " + pocho.getNombre());
        } else if (clasificacionPocho < clasificacionPepe) {
            System.out.println("El ganador es " + pepe.getNombre());
        } else {
            System.out.println("Ambos jugadores tienen la misma clasificación.");
        }*/

        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);
        RevolverAgua revolver = new RevolverAgua();

        Juego juego = new Juego();
        juego.llenarJuego(jugador1, jugador2, revolver);

        revolver.llenarRevolver();
        System.out.println(revolver);

        juego.ronda();

        Jugador jugadorMojado = jugador1.estaMojado() ? jugador1 : jugador2;
        System.out.println("El jugador mojado es: " + jugadorMojado);
    }
}


