package EJ1;

public class Barco {

    public Barco(String matricula, double eslora, int anoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anoFabricacion = anoFabricacion;
    }

    private String matricula;

    private double eslora;

    private int anoFabricacion;

    public double calcularModulo() {
        return eslora * 10;
    }
}
