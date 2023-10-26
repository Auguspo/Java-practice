package Ej1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NO ICE
 */
public class PruebaArreglo {

    public static void main(String[] args) {
        int[] arreglo1 = {1, 2, 3, 4, 5};
        Ej1.sumarLista(arreglo1);

        int[][] arreglo2 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        int mayor = Ej1.buscarMayor(arreglo2);
        System.out.println("Mayor: " + mayor);

        String cadena = "Hola, ¿cómo estás?";
        int cantidadVocales = Ej1.cuentaVocales(cadena);
        System.out.println("Cantidad de vocales: " + cantidadVocales);

        char caracter = 'o';
        int cantidadCaracter = Ej1.cuentaCaracter(cadena, caracter);
        System.out.println("Cantidad de veces que se repite '" + caracter + "': " + cantidadCaracter);
    }
}
