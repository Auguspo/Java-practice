package EJ2;

public class Electrodomestico {

    private double precio;
    private String color;
    private char consumoEnergetico;
    private double peso;

    public Electrodomestico() {
        this.precio = 0;
        this.color = "blanco";
        this.consumoEnergetico = 'F';
        this.peso = 0;
    }

    public Electrodomestico(double precio, String color, char consumoEnergetico, double peso) {
        this.precio = precio;
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        comprobarColor(color);
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        comprobarConsumoEnergetico(consumoEnergetico);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    private void comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            this.consumoEnergetico = letra;
        } else {
            this.consumoEnergetico = 'F';
        }
    }

    private void comprobarColor(String color) {
        String colorLowerCase = color.toLowerCase();
        if (colorLowerCase.equals("blanco") || colorLowerCase.equals("negro")
                || colorLowerCase.equals("rojo") || colorLowerCase.equals("azul")
                || colorLowerCase.equals("gris")) {
            this.color = colorLowerCase;
        } else {
            this.color = "blanco";
        }
    }

    public double precioFinal() {
        double precioFinal = precio;
        switch (consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }
        if (peso >= 0 && peso < 19) {
            precioFinal += 10;
        } else if (peso >= 19 && peso < 49) {
            precioFinal += 50;
        } else if (peso >= 49 && peso < 79) {
            precioFinal += 80;
        } else if (peso >= 79) {
            precioFinal += 100;
        }
        return precioFinal;
    }
}
