package guia2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NOICE
 */
public class Numero {
    private int numero;
    /**
     * @return the numero
     */
    
    Numero (int numero){
        this.numero=numero;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String esPar (){
        if(this.numero %2 ==0)
            {return "Es par";
            }
        
           return "No es par";
  
    }
       
    public String esPositivo (){
        if(this.numero >0)
            {return "Es positivo";
            }

          return "Es negativo";

        
    }
        
    public String esMultiploDe (int divisor){
        if(this.numero % divisor ==0)
             {return "Es multiplo";
            }
      return "No es multiplo";
    }  
    }
    

    
   

