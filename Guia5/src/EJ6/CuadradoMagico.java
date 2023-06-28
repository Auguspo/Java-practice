/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ6;

/**
 *
 * @author NOICE
 */
public class CuadradoMagico {
    private int[][] cuadrado;

    public CuadradoMagico(int[][] cuadrado) {
        this.cuadrado = cuadrado;
    }

    public boolean esCuadradoMagico() {
        int n = cuadrado.length;
        int sumaObjetivo = sumaFila(0); // Suma objetivo para comparar

        // Comprobación de filas
        for (int i = 0; i < n; i++) {
            if (sumaFila(i) != sumaObjetivo) {
                return false;
            }
        }

        // Comprobación de columnas
        for (int j = 0; j < n; j++) {
            if (sumaColumna(j) != sumaObjetivo) {
                return false;
            }
        }

        // Comprobación de diagonal principal
        if (sumaDiagonalPrincipal() != sumaObjetivo) {
            return false;
        }

        // Comprobación de diagonal secundaria
        if (sumaDiagonalSecundaria() != sumaObjetivo) {
            return false;
        }

        return true; // Si todas las comprobaciones son exitosas, es un cuadrado mágico
    }

    private int sumaFila(int fila) {
        int suma = 0;
        for (int j = 0; j < cuadrado.length; j++) {
            suma += cuadrado[fila][j];
        }
        return suma;
    }

    private int sumaColumna(int columna) {
        int suma = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            suma += cuadrado[i][columna];
        }
        return suma;
    }

    private int sumaDiagonalPrincipal() {
        int suma = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            suma += cuadrado[i][i];
        }
        return suma;
    }

    private int sumaDiagonalSecundaria() {
        int suma = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            suma += cuadrado[i][cuadrado.length - 1 - i];
        }
        return suma;
    }
}
