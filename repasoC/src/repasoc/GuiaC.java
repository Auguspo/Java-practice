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
    
}
