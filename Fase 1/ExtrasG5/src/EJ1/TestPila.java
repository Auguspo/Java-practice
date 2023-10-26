package EJ1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author NO ICE
 */
public class TestPila {

    public static void main(String[] args) {
        Pila pila = new Pila(10);

        // Agregar palabras a la pila
        pila.agregar("Hola");
        pila.agregar("Mundo");
        pila.agregar("en");
        pila.agregar("Java");
        pila.agregar("es");

        // Mostrar los datos guardados en la pila sin perderlos
        Pila pilaAuxiliar = new Pila(10);
        while (!pila.pilaVacia()) {
            String elemento = pila.quitar();
            System.out.println(elemento);
            pilaAuxiliar.agregar(elemento);
        }

        // Devolver los elementos a la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            pila.agregar(pilaAuxiliar.quitar());
        }
    }
}
