package EJ1;

public class Velero extends Barco {

    private int numeroMastiles;

    public Velero(int numeroMastiles, String matricula, double eslora, int anoFabricacion) {
        super(matricula, eslora, anoFabricacion);
        this.numeroMastiles = numeroMastiles;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + numeroMastiles;
    }
}
