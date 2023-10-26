package EJ3;


public class Rectangulo implements calculosFormas {

    private double base;

    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcularPerimetro() {
        return (base + altura) * 2;
    }
}
