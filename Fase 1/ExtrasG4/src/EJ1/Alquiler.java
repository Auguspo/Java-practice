package EJ1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {

    public Alquiler(String nombreCliente, int documentoCliente, LocalDate fechaAlquiler, LocalDate fechaDevolucion, int posicionAmarre, Barco barco) {
        this.nombreCliente = nombreCliente;
        this.documentoCliente = documentoCliente;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    private String nombreCliente;

    private int documentoCliente;

    private LocalDate fechaAlquiler;

    private LocalDate fechaDevolucion;

    private int posicionAmarre;

    private Barco barco;

    public double calcularPrecio() {
        long diasOcupacion = ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion) + 1;
        double moduloBarco = barco.calcularModulo();
        return diasOcupacion * moduloBarco;
    }
}
