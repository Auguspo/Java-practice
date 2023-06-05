package EJ2;

public class Camion extends Vehiculo {

    public Camion(String marca, String patente, String tipoCombustible, double precioCombustible) {
        super(marca, patente, tipoCombustible, precioCombustible);
    }

    public double calcularCostoDeCombustible(int distancia) {
        double consumoCombustible = 12; // Consumo de combustible para camiones: 12 Lts cada 100 Km
        return (consumoCombustible / 100) * distancia * getPrecioCombustible();
    }

}
