package Ej5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author NOICE
 */
public class ExtrasG3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        Dado dado3 = new Dado();

        // b) Crear un Jugador de nombre “Pocho” y pedirle que tire los 3 Dados.
        Jugador pocho = new Jugador("Pocho");
        pocho.tirarDado(dado1);
        pocho.tirarDado(dado2);
        pocho.tirarDado(dado3);

        // c) Mostrar al final la clasificación del Jugador.
        System.out.println("Clasificación de " + pocho.getNombre() + ": " + pocho.verClasificacion());

        // d) Ahora Crear otros 3 Dados más.
        Dado dado4 = new Dado();
        Dado dado5 = new Dado();
        Dado dado6 = new Dado();

        // e) Crear un nuevo Jugador de nombre “Pepe” y pedirle que tire los 3 últimos dados creados.
        Jugador pepe = new Jugador("Pepe");
        pepe.tirarDado(dado4);
        pepe.tirarDado(dado5);
        pepe.tirarDado(dado6);
        System.out.println("Clasificación de " + pepe.getNombre() + ": " + pepe.verClasificacion());
        // f) Al finalizar mostrar de los 2 jugadores el nombre que obtuvo la mayor clasificación.
        int clasificacionPocho = pocho.verClasificacion();
        int clasificacionPepe = pepe.verClasificacion();

        if (clasificacionPocho > clasificacionPepe) {
            System.out.println("El ganador es " + pocho.getNombre());
        } else if (clasificacionPocho < clasificacionPepe) {
            System.out.println("El ganador es " + pepe.getNombre());
        } else {
            System.out.println("Ambos jugadores tienen la misma clasificación.");
        }*/

 /* Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);
        RevolverAgua revolver = new RevolverAgua();

        Juego juego = new Juego();
        juego.llenarJuego(jugador1, jugador2, revolver);

        revolver.llenarRevolver();
        System.out.println(revolver);

        juego.ronda();

        Jugador jugadorMojado = jugador1.estaMojado() ? jugador1 : jugador2;
        System.out.println("El jugador mojado es: " + jugadorMojado);*/
 /*Producto producto1 = new Producto("Producto 1", 100.0, 10, "Lácteo");
        Producto producto2 = new Producto("Producto 2", 200.0, 5, "Limpieza");
        Producto producto3 = new Producto("Producto 3", 300.0, 3, "Otro tipo");

        // b) Crear un Cliente y un Vendedor.
        Cliente cliente = new Cliente("Nombre del Cliente", "San Luis");
        Vendedor vendedor = new Vendedor("Nombre del Vendedor");

        // c) Crear una Venta del Vendedor creado en el punto b para el Cliente creado en el punto b y con los 3 productos del punto a.
        Producto[] productosVenta = {producto1, producto2, producto3};
        Venta venta = new Venta(cliente, vendedor, productosVenta);

        // d) Solicitar a la Venta que informe el total.
        double totalVenta = venta.calcularTotal();
        System.out.println("El total de la venta es: $" + totalVenta);*/
        TanqueAgua tanque = new TanqueAgua(5000);
       

        Motor motor = new Motor(tanque, "MEDIA");

        Bomba bomba = new Bomba(motor);
        bomba.regar();
        bomba.mostrarInfor();
           
    }
}
