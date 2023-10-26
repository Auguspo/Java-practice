package EJ4;


/**
 *
 * @author NOICE
 */
public abstract class Personaje {

    public Personaje(Position ubicacion, String nick) {
        this.ubicacion = ubicacion;
        this.nick = nick;
        this.vidas = 3;
        this.energia = 100;
        this.orientacion = 'N';
    }

    public Position getUbicacion() {
        return ubicacion;
    }

    public String getNick() {
        return nick;
    }

    public int getVidas() {
        return vidas;
    }

    public int getEnergia() {
        return energia;
    }

    public char getOrientacion() {
        return orientacion;
    }

    private Position ubicacion;
    private String nick;
    private int vidas;
    private int energia;
    private char orientacion;

    public void disparar() {
        if (energia >= 10) {
            energia -= 10;
            System.out.println("¡Disparo realizado!");
        } else {
            System.out.println("No tienes suficiente energía para disparar.");
        }
    }

    public void girar() {
        switch (orientacion) {
            case 'N':
                orientacion = 'E';
                break;
            case 'E':
                orientacion = 'S';
                break;
            case 'S':
                orientacion = 'O';
                break;
            case 'O':
                orientacion = 'N';
                break;
            default:
                break;
        }
        System.out.println("Nuevo orientación: " + orientacion);
    }

    public void avanzar() {
        switch (orientacion) {
            case 'N':
                ubicacion.setY(ubicacion.getY() + 1);
                break;
            case 'S':
                ubicacion.setY(ubicacion.getY() - 1);
                break;
            case 'E':
                ubicacion.setX(ubicacion.getX() + 1);
                break;
            case 'O':
                ubicacion.setX(ubicacion.getX() - 1);
                break;
            default:
                break;
        }
        System.out.println("Nueva posición: (" + ubicacion.getX() + ", " + ubicacion.getY() + ")");
    }

}
