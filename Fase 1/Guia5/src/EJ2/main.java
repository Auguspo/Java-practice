/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2;

/**
 *
 * @author NO ICE
 */
public class main {

    public static void main(String[] args) {
        int[] vector = new int[100];

        // Llenar el vector con los 100 primeros números enteros
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 100 - i;
        }

        // Mostrar los números en orden descendente
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (vector[i] % 10 == 0 && vector[i] != 100) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }
}
