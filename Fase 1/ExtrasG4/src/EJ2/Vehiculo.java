package EJ2;

public class Vehiculo {

    private String marca;

    private String patente;

    private String tipoCombustible;

    private double precioCombustible;

    public void untitledMethod() {
    }

    public Vehiculo(String marca, String patente, String tipoCombustible, double precioCombustible) {
        this.marca = marca;
        this.patente = patente;
        this.tipoCombustible = tipoCombustible;
        this.precioCombustible = precioCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getPrecioCombustible() {
        return precioCombustible;
    }
}
