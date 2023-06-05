package EJ4;


/**
 *
 * @author NOICE
 */
public class Guerrero extends Personaje {

    private boolean caballo;

    public Guerrero(boolean caballo, Position ubicacion, String nick) {
        super(ubicacion, nick);
        this.caballo = caballo;
    }

    @Override
    public void avanzar() {
        if (caballo) {
            switch (getOrientacion()) {
                case 'N':
                    getUbicacion().setY(getUbicacion().getY() + 10);
                    break;
                case 'S':
                    getUbicacion().setY(getUbicacion().getY() - 10);
                    break;
                case 'E':
                    getUbicacion().setX(getUbicacion().getX() + 10);
                    break;
                case 'O':
                    getUbicacion().setX(getUbicacion().getX() - 10);
                    break;
                default:
                    break;
            }
            System.out.println("Avance de 10 pasos realizado (con caballo)");
        } else {
            super.avanzar();
        }
    }

    @Override
    public void disparar() {
        if (getEnergia() >= 30) {
            super.disparar();
        } else {
            caballo = false;
            System.out.println("No tienes suficiente energía para disparar. Has perdido el caballo.");
        }
    }

}
