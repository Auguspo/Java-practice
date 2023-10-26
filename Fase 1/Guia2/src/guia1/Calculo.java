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
public class Calculo {

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int valorAbsoluto(int numero) {
        return Math.abs(numero);
    }

    public static void calcularRaices(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            System.out.println("La ecuación no tiene solución real.");
        } else {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las raíces de la ecuación son: " + x1 + " y " + x2);
        }
    }
}

