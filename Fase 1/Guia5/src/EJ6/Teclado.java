/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ6;

/**
 *
 * @author NOICE
 */
import java.util.Scanner;

public class Teclado {

    private static Scanner scanner = new Scanner(System.in);

    public static int[][] leerCuadradoMagico() {
        int[][] cuadrado = new int[3][3];

        System.out.println("Introduce los números del cuadrado mágico (1 al 9):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cuadrado[i][j] = leerNumero();
            }
        }

        return cuadrado;
    }

    private static int leerNumero() {
        int numero;
        while (true) {
            System.out.print("Número: ");
            numero = scanner.nextInt();
            if (numero >= 1 && numero <= 9) {
                break;
            } else {
                System.out.println("Número inválido. Introduce un número entre 1 y 9.");
            }
        }
        return numero;
    }
}


