package Ej3;

public class Venta {

    private Cliente cliente;

    private Vendedor vendedor;

    private Producto[] productos;

    public Venta(Cliente cliente, Vendedor vendedor, Producto[] productos) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productos = productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularPrecioPublico();
        }
        if (cliente.getCiudad().equals("San Luis")) {
            total *= 0.9; // Aplicar descuento del 10% para clientes de San Luis
        } else {
            total *= 0.85; // Aplicar descuento del 15% para clientes de otras provincias
        }
        return total;
    }

}
