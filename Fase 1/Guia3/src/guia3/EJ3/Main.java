/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia3.EJ3;


public class Main {
    public static void main(String[] args) {
        Auto miAuto = new Auto("Rojo", "ABC-123");
        miAuto.inflarRuedas();
        miAuto.avanzar(100);
        miAuto.desinflarRuedas();
        miAuto.retroceder(50);
        miAuto.llenarTanque();
    }
}
