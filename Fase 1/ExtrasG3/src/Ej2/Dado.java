package extrasg3;

import java.util.Random;

public class Dado {

    private int numero;

    public void generarNro() {
                if (this.numero == 0) {
            Random random = new Random();
            this.numero = random.nextInt(6) + 1;
        }
    }

    public int verNro() {
        return this.numero;
    }
}
