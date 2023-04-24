/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extrasg1;
import java.util.Scanner;
/**
 *
 * @author NOICE
 */
public class ExtrasG1 {
    public static void minToHs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantaidad de minutos a convertir:");
        int input = sc.nextInt();
        int dias=0, horas=0;
        
        if(input/1440 >0)dias+= input/1440;
        if((input%1440)>0)horas+= (input%1440)/60;
        
        System.out.println(input + " minutos equivalen a " + dias +" dias y " + horas +" horas.");         
    }
    
    public static void intercambiarValores() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Ingrese el valor de A:");
    int A= sc.nextInt();
    
    System.out.println("Ingrese el valor de B:");
    int B= sc.nextInt();
    
    System.out.println("Ingrese el valor de C:");
    int C= sc.nextInt();
    
    System.out.println("Ingrese el valor de D:");
    int D= sc.nextInt();
    
    int aux = B; // Utilizamos una variable auxiliar para guardar el valor de B
   
    
    System.out.println("Valores iniciales:");
    System.out.println("A = " + A);
    System.out.println("B = " + B);
    System.out.println("C = " + C);
    System.out.println("D = " + D);
    
  
    B = C;
    C = A;
    A = D;
    D = aux;
    

    System.out.println("Valores finales:");
    System.out.println("A = " + A);
    System.out.println("B = " + B);
    System.out.println("C = " + C);
    System.out.println("D = " + D);
}
    
    public static void esVocal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribi una letra para ver si es vocal");
        String letra = sc.next().toUpperCase();
       
        if(letra.length() > 1)
            System.out.println("Muchas letras");
        else if(letra.equals("A") || letra.equals("E") || letra.equals("I") || letra.equals("O") || letra.equals("U")) 
            System.out.println("Es vocal AEIOU");
        else System.out.println("No es vocal AEIOU");
    }
    
    public static void Roman(){
        String[] roman={"I","II","III","IV","V","VI","VII","VIII","IX","X"}; 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entre 1 y 10;");
        int numero = sc.nextInt();
        
        if(numero<1 || numero>10)
            System.out.println("Fuera de rango.");
        else
            System.out.println("El numero en romano es: " + roman[numero-1]);
            
        
    }    
    
    public static void ObraSocial(){
        Scanner sc = new Scanner(System.in);
        double importe;
        System.out.println("Escribi una letra para ver su plan.");
        String letra = sc.next().toUpperCase();
        System.out.println("Ingrese un importe.");      
                
        if(letra.length() > 1)
            System.out.println("Muchas letras");
        else if(letra.equals("A")){
            importe = sc.nextDouble();
            System.out.println("Usted debera pagar $" + importe*0.5);}
        else if(letra.equals("B")){
            importe = sc.nextDouble();
            System.out.println("Usted debera pagar $" + importe*0.65);}
        else if(letra.equals("C")){
            importe = sc.nextDouble();
            System.out.println("Usted debera pagar $" + importe);}
        else
            System.out.println("No ingreso una letra correspondiente");
     
    }
    
        public static void Estatura() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de personas: ");
        int n = sc.nextInt();
        
        double[] estaturas = new double[n];
        double sumaEstaturas = 0;
        int contador = 0;
        double sumaEstaturasMenores = 0;
        int contadorMenores = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la estatura de la persona " + (i+1) + " en metros: ");
            estaturas[i] = sc.nextDouble();
            sumaEstaturas += estaturas[i];
            contador++;
            if (estaturas[i] < 1.60) {
                sumaEstaturasMenores += estaturas[i];
                contadorMenores++;
            }
        }
        
        double promedioEstaturas = sumaEstaturas / contador;
        double promedioEstaturasMenores = sumaEstaturasMenores / contadorMenores;
        
        System.out.println("El promedio de estaturas en general es de " + promedioEstaturas + " metros.");
        System.out.println("El promedio de estaturas menores a 1.60 metros es de " + promedioEstaturasMenores + " metros.");
    }
    
}
