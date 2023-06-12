package EJ2;

public class Dato {

    public Dato(String nombre, String apellido, double milimetros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.milimetros = milimetros;
    }

    private String nombre;

    private String apellido;
    
    private double milimetros;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getMilimetros() {
        return milimetros;
    }

}
