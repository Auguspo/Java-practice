package EJ1;

public class Animal {

    private String nombre;

    private String alimento;

    private int edad;

    private String raza;

    public Animal(String nombre, String alimento, int edad, String raza) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.raza = raza;
    }
    
    public void Alimentarse() {
        System.out.println(nombre + " se alimenta de " + alimento);
    }
}
