package EJ1;


public class Pila {

    private int tope;

    private String[] arreglo;

    public Pila(int tamaño) {
        this.tope = -1;
        arreglo = new String[tamaño];
    }

    public void agregar(String elem) {
        if (!pilaLlena()) {
            tope++;
            arreglo[tope] = elem;
        } else {
            System.out.println("La pila está llena, no se puede agregar el elemento.");
        }
    }

    public String verTope() {
        if (!pilaVacia()) {
            return arreglo[tope];
        } else {
            System.out.println("La pila está vacía, no hay elementos para mostrar.");
            return null;
        }
    }

    public String quitar() {
        if (!pilaVacia()) {
            String elemento = arreglo[tope];
            tope--;
            return elemento;
        } else {
            System.out.println("La pila está vacía, no se puede quitar ningún elemento.");
            return null;
        }
}
    

    public boolean pilaVacia() {
        return tope == -1;
    }

    public boolean pilaLlena() {
        return tope != -1;
    }
}
