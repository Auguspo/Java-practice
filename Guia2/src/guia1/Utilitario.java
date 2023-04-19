/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
 * @author NOICE
 */
public class Utilitario {
       
   public static void dibujaCuadrado(int n){
       
        for(int i=0;i<n;i++){
          System.out.print("* ");   
        }
        
        System.out.println();
        
        for (int i = 2; i < n; i++) {
            
            System.out.print("* ");
            
            for (int j = 2; j < n; j++) {
                System.out.print("  ");
            }
            
            System.out.println("*");
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        
        System.out.println();
   }

    public static void elMayorEs(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("Los tres números son iguales: " + a);
        } else if (a >= b && a >= c) {
            System.out.println("El mayor es: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("El mayor es: " + b);
        } else {
            System.out.println("El mayor es: " + c);
        }
    }
    public static String elDiaEs(int numDia) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        if (numDia >= 1 && numDia <= 7) {
            return dias[numDia - 1];
        } else {
            return "No existe ese día!!!";
        }
  }
}
