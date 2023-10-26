/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

public class Conversor {
    
    private static final double cambio = 412;
    
    public static double convetirAPesos(double dolares){
        return dolares*cambio;
    }
    
    public double convetirADolares(double pesos){
        return pesos/cambio;
    }
}
