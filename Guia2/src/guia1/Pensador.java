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
public class Pensador {
    private int valor;

    public Pensador(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    public int invertir() {
        int numeroInvertido = 0;
        int numeroRestante = valor;
        while (numeroRestante != 0) {
            int digito = numeroRestante % 10;
            numeroInvertido = numeroInvertido * 10 + digito;
            numeroRestante /= 10;
        }
        return numeroInvertido;
    }
    
    public int parAntes() {
    int valorPar = valor % 2 == 0 ? valor : valor - 1;
    return valorPar - 2;
    }
    
    public int parPosterior() {
        int valorPar = valor % 2 == 0 ? valor : valor + 1;
        return valorPar + 2;
    }

    public int primerDigito() {
        int primerDigito = valor;
        while (primerDigito >= 10) {
            primerDigito /= 10;
        }
        return primerDigito;
    }

    public int ultimoDigito() {
        return valor % 10;
    }
}
