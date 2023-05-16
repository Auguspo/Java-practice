package extrasg3;

public class Jugador {

    private String nombre;
    private int clasificacion;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.clasificacion=0;
    }

  
    public void tirarDado(Dado dado) {
       dado.generarNro();
       this.clasificacion += dado.verNro();
       
    }

    public int verClasificacion() {
        return this.clasificacion;
                
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
   
}

