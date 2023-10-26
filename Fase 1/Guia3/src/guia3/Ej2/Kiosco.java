/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej2;

import java.util.Date;

public class Kiosco {   
    private final String nombre;
    private final String direccion;
    private final String cuit;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;
    
    public Kiosco(String nombre, String direccion, String cuit){
        this.direccion = direccion;
        this.nombre = nombre;
        this.cuit = cuit;
    }
    
    public void agregarEmpleado(Empleado empleado) {
        if (empleado1 == null) {
            empleado1 = empleado;
        } else if (empleado2 == null) {
            empleado2 = empleado;
        } else if (empleado3 == null) {
            empleado3 = empleado;
        } else {
            System.out.println("El kiosco ya tiene 3 empleados");
        }
    }

    public Empleado getEmpleadoAntiguo() {
        Empleado empleadoAntiguo = empleado1;
        if (empleado2 != null && empleado2.getFechaIngreso().before(empleadoAntiguo.getFechaIngreso())) {
            empleadoAntiguo = empleado2;
        }
        if (empleado3 != null && empleado3.getFechaIngreso().before(empleadoAntiguo.getFechaIngreso())) {
            empleadoAntiguo = empleado3;
        }
        return empleadoAntiguo;
    }

 public static void main(String[] args) {
        Kiosco kiosco = new Kiosco("Av. Corrientes 1234", "El kiosco de Juan", "20-12345678-0");
        Empleado empleado1 = new Empleado("Juan", "Pérez", new Date(2010, 5, 1), "12345678");
        Empleado empleado2 = new Empleado("María", "Gómez", new Date(2015, 2, 10), "23456789");
        Empleado empleado3 = new Empleado("Pedro", "Rodríguez", new Date(2018, 9, 3), "34567890");
        
        kiosco.agregarEmpleado(empleado1);
        kiosco.agregarEmpleado(empleado2);
        kiosco.agregarEmpleado(empleado3);
        
        Empleado empleadoAntiguo = kiosco.getEmpleadoAntiguo();
        
        System.out.println("El empleado más antiguo es " + empleadoAntiguo.getNombre() +" "+ empleadoAntiguo.getApellido() +" "+ empleadoAntiguo.getDni());

    }
}