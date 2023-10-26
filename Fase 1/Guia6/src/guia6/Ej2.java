/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia6;

/**
 *
 * @author NOICE
 */
public class Ej2 {
     public static void main(String[] args) {
      try {
            // Crear un arreglo de tamaño 5
            int[] arreglo = new int[5];
            
            // Provocar intencionalmente una ArrayIndexOutOfBoundsException
            int valor = arreglo[10]; // Esto provocará la excepción
        } catch (ArrayIndexOutOfBoundsException e) {
            // Manejar la excepción
            System.out.println("Se ha producido una excepción ArrayIndexOutOfBoundsException:");
            System.out.println("Mensaje de error: " + e.getMessage());
            
            // Mostrar el resultado de fillInStackTrace()
            System.out.println("Resultado de fillInStackTrace():");
            e.printStackTrace(System.out);
    }
}
