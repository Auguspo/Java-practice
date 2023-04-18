/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

/**
 *
 * @author NOICE
 */
public class Fecha {

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }
    private int dia,mes,año;
    
    public Fecha(int dia, int mes, int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    
    public boolean esBisiesto(){
        if(getAño() %4 == 0){
            return true;
        }else{
            return false;}
    }
    
    public int calcularAños(Fecha otraFecha){
    int añosTranscurridos = otraFecha.getAño() - this.año;
        if (otraFecha.getMes() < this.mes || (otraFecha.getMes() == this.mes && otraFecha.getDia() < this.dia)) {
            añosTranscurridos--;
        }
        return añosTranscurridos;
    }
    
    
}
