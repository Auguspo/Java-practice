package Ej3;

public class Producto {

    private String descripcion;

    private double precioLista;

    private int stock;

    private String tipoProducto;

    public Producto() {
    }

    public Producto(String descripcion, double precioLista, int stock, String tipoProducto) {
        this.descripcion = descripcion;
        this.precioLista = precioLista;
        this.stock = stock;
        this.tipoProducto = tipoProducto;
    }

    public double calcularPrecioPublico() {
        if (tipoProducto.equals("Lácteo")) {
            return precioLista * 1.25;
        } else if (tipoProducto.equals("Limpieza")) {
            return precioLista * 1.35;
        } else {
            return precioLista * 1.45;
        }
    }
}
