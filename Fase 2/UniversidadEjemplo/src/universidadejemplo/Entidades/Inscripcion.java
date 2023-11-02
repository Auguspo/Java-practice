package universidadejemplo.Entidades;

public class Inscripcion {

    /**
     * @return the idInscripcion
     */
    public int getIdInscripcion() {
        return idInscripcion;
    }

    /**
     * @param idInscripcion the idInscripcion to set
     */
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    private int idInscripcion;

    private Alumno alumno;

    private Materia materia;

    private double nota;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "ID de Inscripción: " + idInscripcion
                + "\nAlumno: " + alumno.getNombre() + " " + alumno.getApellido()
                + "\nMateria: " + materia.getNombre()
                + "\nNota: " + nota;
    }
}
