/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia6;

/**
 *
 * @author NOICE
 */
public class Ej3 {
    import java.util.Scanner;

public class DivisionNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        String numero1Str = scanner.nextLine();
        
        System.out.print("Ingrese el segundo número: ");
        String numero2Str = scanner.nextLine();
        
        try {
            // Convertir las cadenas a enteros
            int numero1 = Integer.parseInt(numero1Str);
            int numero2 = Integer.parseInt(numero2Str);
            
            // Realizar la división y mostrar el resultado
            if (numero2 != 0) {
                int resultado = numero1 / numero2;
                System.out.println("El resultado de la división es: " + resultado);
            } else {
                System.out.println("No se puede dividir por cero.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese números válidos en formato entero.");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        } finally {
            scanner.close(); // Cerrar el scanner al finalizar
        }
    }
}

}
