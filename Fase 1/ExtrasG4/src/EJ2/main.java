/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2;

/**
 *
 * @author NO ICE
 */
public class main {

    public static void main(String[] args) {
        // Crear un objeto de tipo Vehiculo
        Vehiculo vehiculo = new Auto("Ford", "ABC123", "Gasolina", 4.5);

        // Crear un objeto de tipo Viaje
        Viaje viaje = new Viaje("San Luis", "Rufino", 200, "Gasolina", vehiculo, 2, true, 100, 300);

        // Calcular el costo total del viaje
        double costoTotal = viaje.calcularCostoTotal();

        // Imprimir el costo total del viaje
        System.out.println("Costo total del viaje: $" + costoTotal);
    }
}
