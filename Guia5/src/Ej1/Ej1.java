package Ej1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NOICE
 */
public class Ej1 {

    public static void sumarLista(int[] arreglo) {
        int suma = 0;

        for (int num : arreglo) {
            suma += num;
        }
        System.out.println("La suma del arreglo es: " + suma);

        double promedio = (double) suma / arreglo.length;
        System.out.println("El promedio del arreglo es: " + promedio);

    }

    public static int buscarMayor(int[][] arreglo) {

        int mayor = 0;

        for (int[] fila : arreglo) {
            for (int num : fila) {
                if (num > mayor) {
                    mayor = num;
                }
            }

        }
        return mayor;
    }

    public static int cuentaVocales(String cadena) {
        int contadorV = 0;
        cadena = cadena.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contadorV++;
            }
        }
        return contadorV;
    }

    public static int cuentaCaracter(String cadena, char caracter) {
        int contadorC = 0;
        cadena = cadena.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter2 = cadena.charAt(i);
            if (caracter == caracter2) {
                contadorC++;
            }

        }
        return contadorC;
    }
}

