package EJ1;

public class Yate extends Barco {

    private int potenciaCV;

    private int numeroCamarotes;

    public Yate(int potenciaCV, int numeroCamarotes, String matricula, double eslora, int anoFabricacion) {
        super(matricula, eslora, anoFabricacion);
        this.potenciaCV = potenciaCV;
        this.numeroCamarotes = numeroCamarotes;
    }

    public double calcularModulo() {
        return super.calcularModulo() + potenciaCV + numeroCamarotes;
    }
}
