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
public class Circulo {
    private final double  PI = 3.14;
    private double radio;
    /**
     * @return the PI
     */
    public double getPI() {
        return PI;
    }

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

  public Circulo( double radio){
      this.radio=radio;
  }
  
  public double calcularArea(){
     return this.PI*(this.radio*2);
      
    
  }
  
  public double calcularPerimetro(){
      return 2*this.PI*(this.radio);    
    }
  
  
}
