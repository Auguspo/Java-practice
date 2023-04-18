/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author NOICE
 */
public class Persona {
    private String apellido;
    private String nombre;
    private int edad;
    
    public Persona(String apellido, String nombre, int edad){
        this.apellido= apellido;
        this.nombre= nombre;
        this.edad = edad;
        }
    
   public Persona(){}
   
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public void saludar(){
    System.out.println("Hola, mi nombres es " + nombre);
       
    }
    }
    
  

