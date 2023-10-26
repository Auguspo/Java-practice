/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ6;

/**
 *
 * @author NOICE
 */
public class Main {

    public static void main(String[] args) {
        int[][] cuadrado = Teclado.leerCuadradoMagico();
        CuadradoMagico cuadradoMagico = new CuadradoMagico(cuadrado);

        if (cuadradoMagico.esCuadradoMagico()) {
            System.out.println("¡El cuadrado introducido es mágico!");
        } else {
            System.out.println("El cuadrado introducido NO es mágico.");
        }
    }
}
