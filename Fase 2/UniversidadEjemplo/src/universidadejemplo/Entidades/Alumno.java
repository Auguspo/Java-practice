package universidadejemplo.Entidades;

import java.time.LocalDate;

public class Alumno {

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private int idAlumno;
    private int dni;
    private String apellido;

    private String nombre;

    private LocalDate fechaNac;

    private boolean activo;

    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.apellido = apellido;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno() {
    }

    @Override
    public String toString() {
        return "ID de Alumno: " + idAlumno
                + "\nDNI: " + dni
                + "\nNombre: " + nombre
                + "\nApellido: " + apellido
                + "\nFecha de Nacimiento: " + fechaNac
                + "\nActivo: " + (activo ? "Sí" : "No");
    }
}
