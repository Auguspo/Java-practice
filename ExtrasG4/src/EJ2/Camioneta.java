package EJ2;

public class Camioneta extends Vehiculo {

    public Camioneta(String marca, String patente, String tipoCombustible, double precioCombustible) {
        super(marca, patente, tipoCombustible, precioCombustible);
    }
        public double calcularCostoDeCombustible(int distancia) {
        double consumoCombustible = 10; // Consumo de combustible para camionetas: 10 Lts cada 100 Km
        return (consumoCombustible / 100) * distancia * getPrecioCombustible();
    }
}
