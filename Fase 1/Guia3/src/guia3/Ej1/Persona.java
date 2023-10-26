/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej1;

import guia3.Ej1.Perro;

/**
 *
 * @author NOICE
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    private Perro perro1;
    private Perro perro2;
    private Perro perro3;

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public void adoptarPerro(Perro perro) {
        if (perro1 == null) {
            perro1 = perro;
        } else if (perro2 == null) {
            perro2 = perro;
        } else if (perro3 == null) {
            perro3 = perro;
        } else {
            System.out.println("Ya no puedo adoptar");
        }
    }

    public Perro perroMasGrande() {
        Perro mayor = perro1;
        if (perro2 != null && perro2.getEdad() > mayor.getEdad()) {
            mayor = perro2;
        }
        if (perro3 != null && perro3.getEdad() > mayor.getEdad()) {
            mayor = perro3;
        }
        return mayor;
    }
 
      public static void main(String[] args) {
        Perro perro1 = new Perro("Fido", "Labrador", 3, "Grande");
        Perro perro2 = new Perro("Bobby", "Chihuahua", 5, "Pequeño");
        Perro perro3 = new Perro("Rocky", "Pitbull", 2, "Mediano");
        Perro perro4 = new Perro("Max", "Golden Retriever", 4, "Grande");

        Persona persona = new Persona("Juan", "Perez", 30, 12345678);

        persona.adoptarPerro(perro1);
        persona.adoptarPerro(perro2);
        persona.adoptarPerro(perro3);
        persona.adoptarPerro(perro4); // Esto debería imprimir "Ya no puedo adoptar"

        Perro perroMasViejo = persona.perroMasGrande();
        System.out.println("El perro más viejo es: " + perroMasViejo.getNombre());
    }
    
}
  