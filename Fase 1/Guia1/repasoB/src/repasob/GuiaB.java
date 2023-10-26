/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasob;
import java.util.Scanner;
/**
 *
 * @author NOICE
 */
public class GuiaB {
    
    public static void quienMayor(int a, int b){
        if(a>b){System.out.println(a + "es mayor.\n");}
        else if(b<a){System.out.println(b + "es mayor.\n");}
        else System.out.println("Son iguales\n");
    }
    
    public static void esPar(int num){
    if(num%2 == 0){System.out.println("Es par.\n");}
    else{System.out.println("Es impar.\n");}
    }
    
    public static void isEureka(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.next();
        if(frase.equals("eureka")){System.out.println("Correcto\n");}
        else{System.out.println("Incorrecto\n");}
    }
    
    public static void is8(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.next();
        if(frase.length() == 8){System.out.println("Correcto\n");}
        else{System.out.println("Incorrecto\n");}
    }
    
     public static void firstLetter(){
         
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una palabra o frase: ");
        String frase = sc.nextLine();

        if (frase.charAt(0) == 'A') {
            System.out.println("CORRECTO");
        } else {
            System.out.println("INCORRECTO");
        }
    }
     
    public void mostrarTipoMotor(){
        int tipoMotor;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un valor para el tipo de motor (1-4): ");
        tipoMotor = scanner.nextInt();
        
        switch (tipoMotor) {
            case 1:
                System.out.println("La bomba es una bomba de agua");
                break;
            case 2:
                System.out.println("La bomba es una bomba de gasolina");
                break;
            case 3:
                System.out.println("La bomba es una bomba de hormigón");
                break;
            case 4:
                System.out.println("La bomba es una bomba de pasta alimenticia");
                break;
            default:
                System.out.println("No existe un valor válido para tipo de bomba");
                break;
        }
        
    }
        
}
