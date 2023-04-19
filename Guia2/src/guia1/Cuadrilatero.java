/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
 * @author NOICE
 */
public class Cuadrilatero {
    private int largo;
    private int alto;
    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
   
    
    public Cuadrilatero(int largo, int alto){
        this.largo=largo;
        this.alto=alto;
    }
    
    public int calcularPerimetro(){
       return 2*this.largo+2*this.alto;
       
    }
    
    public int calcularArea(){
       return this.largo*this.alto;
    }
    
    public String esUnCuadrado(){
        if(this.largo == this.alto){
            return "Es un cuadrilatero";
        }else{
           return "No es un cuadrilatero";
        }
        
    }
}

