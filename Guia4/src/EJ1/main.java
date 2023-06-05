/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ1;

/**
 *
 * @author NOICE
 */
public class main {

    public static void main(String[] args) {

        Animal perro = new Perro("Stich", "Carnivero", 15, "Doberman");
        perro.Alimentarse();

        Perro perro1 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        perro1.Alimentarse();

        Animal gato = new Gato("Pelusa", "Galletas", 16, "Siames");
        gato.Alimentarse();

        Caballo caballo = new Caballo("Spark", "Pasto", 25, "Fino");
        caballo.Alimentarse();
    }
}
