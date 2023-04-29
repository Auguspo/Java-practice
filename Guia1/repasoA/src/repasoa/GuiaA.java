/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoa;

import java.util.Scanner;

/**
 * @author NOICE
 */
public class GuiaA {
    
    public static void sumarDosNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        int suma = num1 + num2;
        System.out.println("La suma de " + num1 + " y " + num2 + " es " + suma);
    }
    
    public static void nombrePrint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.next();
        System.out.println("Su nombre es " + nombre + "?" );
    }
    
    public static void upperLower(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una frase");
        String nombre = sc.next();
        System.out.println("Gritando es " + nombre.toUpperCase() + " y en miniscula es " + nombre.toLowerCase() );
    }
    
    public static void cToF() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la temperatura en Cº: ");
        double tempF = 32+(9* sc.nextDouble()/5);
        System.out.print("La temperatura en F es: "+ tempF +"F\n");
     }
    
    public static void math(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número: ");
        double num = sc.nextDouble();
        System.out.println("El doble es "+ num*2 +", el triple es " + num*3 + "y la raiz cuadrada es "+ Math.sqrt(num)+"\n");
        
    } 
}
