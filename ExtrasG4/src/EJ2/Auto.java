package EJ2;

public class Auto extends Vehiculo {

    public Auto(String marca, String patente, String tipoCombustible, double precioCombustible) {
        super(marca, patente, tipoCombustible, precioCombustible);
    }
   public double calcularCostoDeCombustible(int distancia) {
        double consumoCombustible = 7; // Consumo de combustible para autos: 7 Lts cada 100 Km
        return (consumoCombustible / 100) * distancia * getPrecioCombustible();
    }
}
