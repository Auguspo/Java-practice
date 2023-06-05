/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2;

/**
 *
 * @author NOICE
 */
public class main {

    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora(1000, "blanco", 'A', 50, 35);
        Televisor televisor = new Televisor(1500, "negro", 'B', 20, 50, true);

        System.out.println("Precio final de la lavadora: $" + lavadora.precioFinal());
        System.out.println("Precio final del televisor: $" + televisor.precioFinal());
    }
}
