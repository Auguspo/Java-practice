/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej4;

/**
 *
 * @author NO ICE
 */
import java.util.Random;

public class main {

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        // Llenar la matriz con valores aleatorios
        Random random = new Random();
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                matriz1[j] = random.nextInt(100); // Valores aleatorios entre 0 y 99
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        mostrarMatriz(matriz);

        // Calcular la traspuesta de la matriz
        int[][] traspuesta = obtenerTraspuesta(matriz);

        // Mostrar la traspuesta de la matriz
        System.out.println("Traspuesta de la matriz:");
        mostrarMatriz(traspuesta);
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] obtenerTraspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] traspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        return traspuesta;
    }
}
