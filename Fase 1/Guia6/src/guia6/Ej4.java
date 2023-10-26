/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia6;

/**
 *
 * @author NOICE
 */
public class Ej4 {

    public static void main(String[] args) {
        try {
            // Intentamos convertir una cadena no numérica en un entero
            String cadenaNoNumerica = "Hola";
            int numero = Integer.parseInt(cadenaNoNumerica); // Esto provocará la excepción
        } catch (NumberFormatException e) {
            // Manejamos la excepción
            System.out.println("Se ha producido una excepción NumberFormatException:");
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}

