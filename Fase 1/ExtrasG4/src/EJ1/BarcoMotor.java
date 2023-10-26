package EJ1;

public class BarcoMotor extends Barco {

    public BarcoMotor(int potenciaCV, String matricula, double eslora, int anoFabricacion) {
        super(matricula, eslora, anoFabricacion);
        this.potenciaCV = potenciaCV;
    }

    private int potenciaCV;

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + potenciaCV;
    }
}
