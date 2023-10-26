/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia6;

/**
 *
 * @author NOICE
 */
public class Ej1 {
   public static void main(String[] args) {
        // Provocar intencionalmente una NullPointerException
        String texto = null;

        try {
            // Intentamos acceder a un método o propiedad de un objeto nulo
            int longitud = texto.length(); // Esto provocará una excepción NullPointerException
        } catch (NullPointerException e) {
            // Manejamos la excepción
            System.out.println("Se ha producido una excepción NullPointerException:");
            System.out.println(e.getMessage()); // Muestra el mensaje de error
            e.printStackTrace(); // Muestra la traza de la excepción
        }
    }
}
    
    
}
