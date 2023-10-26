package Ej5;

public class Motor {

    private TanqueAgua tanque;

    private String velocidad;

    public Motor(TanqueAgua tanque, String velocidad) {
        this.tanque = tanque;
        this.velocidad = velocidad;
    }

    public void consumirAgua() {

        switch (getVelocidad()) {
            case "ALTA":
                getTanque().consumir(10);
                break;
            case "MEDIA":
                getTanque().consumir(5);
                break;
            case "BAJA":
                getTanque().consumir(1);
                break;
        }
    }

    public void cambiarVelocidad() {

        switch (getVelocidad()) {
            case "ALTA":
                velocidad = "MEDIA";
                break;
            case "MEDIA":
                velocidad = "BAJA";
                break;
            case "BAJA":
                velocidad = "ALTA";
                break;
        }
    }

    /**
     * @return the tanque
     */
    public TanqueAgua getTanque() {
        return tanque;
    }

    /**
     * @return the velocidad
     */
    public String getVelocidad() {
        return velocidad;
    }
}
