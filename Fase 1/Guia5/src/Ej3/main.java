/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej3;

/**
 *
 * @author NO ICE
 */
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el tamaño del vector
        System.out.print("Ingrese el tamaño del vector: ");
        int N = scanner.nextInt();

        int[] vector = new int[N];

        // Llenar el vector con valores aleatorios
        Random random = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(100); // Valores aleatorios entre 0 y 99

        }

        // Mostrar los números en orden descendente
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);

            System.out.print(", ");
        }
        System.out.println();
        
// Solicitar al usuario el número a buscar
        System.out.print("Ingrese un número a buscar: ");
        int numeroBuscado = scanner.nextInt();

        // Buscar el número en el vector y determinar si está repetido
        boolean encontrado = false;
        boolean repetido = false;
        int posicionEncontrado = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numeroBuscado) {
                if (encontrado) {
                    repetido = true;
                    break;
                }
                encontrado = true;
                posicionEncontrado = i + 1;
            }
        }
        if (encontrado) {
            System.out.println("El número " + numeroBuscado + " se encuentra en la posición " + posicionEncontrado);
            if (repetido) {
                System.out.println("El número " + numeroBuscado + " está repetido en el vector.");
            } else {
                System.out.println("El número " + numeroBuscado + " no está repetido en el vector.");
            }
        } else {
            System.out.println("El número " + numeroBuscado + " no se encuentra en el vector.");
        }
    }
}
