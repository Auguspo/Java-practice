package EJ2;

public class Lavadora extends Electrodomestico {

    private double carga;

    public Lavadora() {
        super();
        this.carga = 0;
    }

    public Lavadora(double precio, String color, char consumoEnergetico, double peso, double carga) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
}
