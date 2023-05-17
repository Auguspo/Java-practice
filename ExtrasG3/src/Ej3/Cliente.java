package Ej3;

public class Cliente {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    private String nombre;

    private String ciudad;

    public Cliente(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad= ciudad;
    }
}
