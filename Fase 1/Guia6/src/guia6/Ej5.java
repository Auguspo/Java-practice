/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NOICE
 */
public class Ej5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAdivinar = random.nextInt(500) + 1;
        int intentos = 0;

        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Intenta adivinar un número entre 1 y 500.");

        while (true) {
            try {
                System.out.print("Ingresa tu adivinanza: ");
                String entradaUsuario = scanner.nextLine();

                // Verificar si el usuario quiere salir del juego
                if (entradaUsuario.equalsIgnoreCase("salir")) {
                    System.out.println("Abandonaste el juego. El número a adivinar era: " + numeroAdivinar);
                    break;
                }

                int numeroUsuario = Integer.parseInt(entradaUsuario);
                intentos++;

                if (numeroUsuario < 1 || numeroUsuario > 500) {
                    System.out.println("El número debe estar entre 1 y 500.");
                } else if (numeroUsuario < numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else if (numeroUsuario > numeroAdivinar) {
                    System.out.println("El número a adivinar es menor.");
                } else {
                    System.out.println("¡Felicidades! Adivinaste el número " + numeroAdivinar + " en " + intentos + " intentos.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
                intentos++;
            }
        }

        scanner.close();
    }

}
