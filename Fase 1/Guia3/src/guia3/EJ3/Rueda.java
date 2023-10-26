package guia3.EJ3;

public class Rueda {
    private String marca;
    private double presion;

    public Rueda() {
        this.marca = "Desconocida";
        this.presion = 28.0;
    }

    public void inflar() {
        this.presion = 28.0;
        System.out.println("Inflando la rueda...");
    }

    public void pinchar() {
        this.presion = 0.0;
        System.out.println("Pinchando la rueda...");
    }

    public void desinflar() {
        this.presion -= 0.5;
        System.out.println("Desinflando la rueda...");
    }
}