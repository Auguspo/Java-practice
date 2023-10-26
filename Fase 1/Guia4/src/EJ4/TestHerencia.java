/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ4;

/**
 *
 * @author NOICE
 */
public class TestHerencia {

    public static void main(String[] args) {
        Position posicion = new Position(100, 200);
        Guerrero thor = new Guerrero(true, posicion, "Thor");

        System.out.println("Posición inicial: (" + thor.getUbicacion().getX() + ", " + thor.getUbicacion().getY() + ")");

        while (thor.getOrientacion() != 'O') {
            thor.girar();
        }

        thor.avanzar();
        thor.avanzar();
        thor.avanzar();
        thor.avanzar();
        thor.avanzar();

        thor.disparar();
        thor.disparar();
        thor.disparar();
        thor.disparar();
        thor.disparar();
        thor.disparar();
        thor.disparar();
        thor.disparar();
    }
}
