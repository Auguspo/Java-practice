/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoc;
import java.util.Scanner;
/**
 *
 * @author NOICE
 */
public class GuiaC {
    
    public static void nota(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una nota: ");
        int nota = sc.nextInt();
        while( nota <0 || nota > 10){System.out.println("Ingrese una nota valida. ");
            nota = sc.nextInt();}
        System.out.println("Correcto, su nota es " + nota);
    }
    
    public static void valor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una valor: ");
        int valor = sc.nextInt();
        int suma = 0;
        while(suma<=valor){
            System.out.println("Ingrese una valor para sumar: ");
            suma+=sc.nextInt();
            System.out.println("Usted lleva " + suma);
        }
        
        System.out.println("Usted ha superado el valor inicial.\n");
    }
    
    
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int num1, num2, opcion, resultado;
        char confirmacion;

        do {
            System.out.println("MENU");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Elija opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el primer número: ");
                    num1 = sc.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = sc.nextInt();
                    resultado = num1 + num2;
                    System.out.println("El resultado de la suma es: " + resultado);
                    break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    num1 = sc.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = sc.nextInt();
                    resultado = num1 - num2;
                    System.out.println("El resultado de la resta es: " + resultado);
                    break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    num1 = sc.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = sc.nextInt();
                    resultado = num1 * num2;
                    System.out.println("El resultado de la multiplicación es: " + resultado);
                    break;
                case 4:
                    System.out.print("Ingrese el primer número: ");
                    num1 = sc.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = sc.nextInt();
                    if (num2 == 0) {
                        System.out.println("No se puede dividir por cero.");
                    } else {
                        resultado = num1 / num2;
                        System.out.println("El resultado de la división es: " + resultado);
                    }
                    break;
                case 5:
                    System.out.print("¿Está seguro que desea salir (S/N)? ");
                    confirmacion = sc.next().charAt(0);
                    if (confirmacion == 'S' || confirmacion == 's') {
                        System.out.println("Saliendo del programa");
                        return;
                    } else {
                        break;
                    }
                default:
                    System.out.println("Opción inválida. Por favor, seleccione otra opción.");
                    break;
            }

        } while (opcion != 5);

    }
      
    
}
