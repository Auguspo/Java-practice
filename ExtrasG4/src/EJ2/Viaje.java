package EJ2;

public class Viaje {

    private String lugarOrigen;

    private String lugarDestino;

    private int distancia;

    private String tipoCombustible;

    private Vehiculo vehiculo;

    private int cantidadPeajes;

    private int kmCiudadOrigen;

    private int kmCiudadDestino;

    public Viaje(String lugarOrigen, String lugarDestino, int distancia, String tipoCombustible, Vehiculo vehiculo, int cantidadPeajes, boolean par2, int par3, int par4) {
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.distancia = distancia;
        this.tipoCombustible = tipoCombustible;
        this.vehiculo = vehiculo;
        this.cantidadPeajes = cantidadPeajes;
    }

    public Viaje(String lugarOrigen, String lugarDestino, String tipoCombustible, Vehiculo vehiculo, int cantidadPeajes, int kmCiudadOrigen, int kmCiudadDestino) {
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.tipoCombustible = tipoCombustible;
        this.vehiculo = vehiculo;
        this.cantidadPeajes = cantidadPeajes;
        this.kmCiudadOrigen = kmCiudadOrigen;
        this.kmCiudadDestino = kmCiudadDestino;
    }

    public int calcularDistancia() {
        if (kmCiudadOrigen != 0 && kmCiudadDestino != 0) {
            return kmCiudadDestino - kmCiudadOrigen;
        } else {
            return distancia;
        }
    }

    public double calcularCostoPeajes() {
        double costoPeaje;
        if (vehiculo instanceof Auto || vehiculo instanceof Camioneta) {
            costoPeaje = 50; // Costo de peajes para autos y camionetas
        } else {
            costoPeaje = 100; // Costo de peajes para camiones
        }
        return costoPeaje * cantidadPeajes;
    }

    public double calcularCostoCombustible() {
        double consumoCombustible;
        if (vehiculo instanceof Auto) {
            consumoCombustible = 7; // Consumo de combustible para autos: 7 Lts cada 100 Km
        } else if (vehiculo instanceof Camioneta) {
            consumoCombustible = 10; // Consumo de combustible para camionetas: 10 Lts cada 100 Km
        } else {
            consumoCombustible = 12; // Consumo de combustible para camiones: 12 Lts cada 100 Km
        }
        double distanciaViaje = calcularDistancia();
        return (consumoCombustible / 100) * distanciaViaje * vehiculo.getPrecioCombustible();
    }

    public double calcularCostoTotal() {
        double costoPeajes = calcularCostoPeajes();
        double costoCombustible = calcularCostoCombustible();
        return costoPeajes + costoCombustible;
    }
}
