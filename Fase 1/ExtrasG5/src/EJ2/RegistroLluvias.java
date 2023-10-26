package EJ2;

public class RegistroLluvias {
    private double[][] registros;
    private String[] localidades;
    private String[] meses;
    private Dato[][] datos;

    public RegistroLluvias() {
        localidades = new String[]{"San Luis", "Merlo", "Villa Mercedes"};
        meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        registros = new double[3][12];
        datos = new Dato[3][12];
    }

    public void agregarRegistro(String localidad, String mes, double promedioLluvias, String nombre, String apellido) {
        int indiceLocalidad = obtenerIndiceLocalidad(localidad);
        int indiceMes = obtenerIndiceMes(mes);
        if (indiceLocalidad != -1 && indiceMes != -1) {
            registros[indiceLocalidad][indiceMes] = promedioLluvias;
            datos[indiceLocalidad][indiceMes] = new Dato(nombre, apellido, promedioLluvias);
        } else {
            System.out.println("La localidad o el mes ingresados no son válidos.");
        }
    }

    public double obtenerPromedioMasAlto() {
        double promedioMasAlto = 0.0;
        for (int i = 0; i < localidades.length; i++) {
            for (int j = 0; j < meses.length; j++) {
                double promedio = registros[i][j];
                if (promedio > promedioMasAlto) {
                    promedioMasAlto = promedio;
                }
            }
        }
        return promedioMasAlto;
    }

    public double obtenerPromedioMasAltoPorLocalidad(String localidad) {
        int indiceLocalidad = obtenerIndiceLocalidad(localidad);
        if (indiceLocalidad != -1) {
            double promedioMasAlto = 0.0;
            for (int j = 0; j < meses.length; j++) {
                double promedio = registros[indiceLocalidad][j];
                if (promedio > promedioMasAlto) {
                    promedioMasAlto = promedio;
                }
            }
            return promedioMasAlto;
        } else {
            System.out.println("La localidad ingresada no es válida.");
            return 0.0;
        }
    }

    public Dato obtenerDatoQueRegistro(String localidad, String mes) {
        int indiceLocalidad = obtenerIndiceLocalidad(localidad);
        int indiceMes = obtenerIndiceMes(mes);
        if (indiceLocalidad != -1 && indiceMes != -1) {
            return datos[indiceLocalidad][indiceMes];
        } else {
            System.out.println("La localidad o el mes ingresados no son válidos.");
            return null;
        }
    }

    public int obtenerIndiceLocalidad(String localidad) {
        for (int i = 0; i < localidades.length; i++) {
            if (localidades[i].equalsIgnoreCase(localidad)) {
                return i;
            }
        }
        return -1;
    }

    public int obtenerIndiceMes(String mes) {
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(mes)) {
                return i;
            }
        }
        return -1;
    }
}
