package modelo.AppClasses;

/**
 * Wrapper para Asignatura, contiene información relevante de los datos del estudiante que la inscribió.
 * Sirve para tener en orden el historial académico y realizar el cómputo de su escolaridad.
 * @author Oscar Rojas
 */
public class AsignaturaInscrita {
    /**
     * El identificador de la Asignatura que el Alumno inscribió.
     */
    private String claveAsignatura;
    
    /**
     * Calificación final que se le asentó al Alumno.
     * Dicha calificación se le asigna un número real entre 5.0 y 10.0.
     * Para considerarse una asignatura como aprobada, la calificación mínima debe de ser 6.0.
     */
    private float calificacionObtenida;
    
    /**
     * Número del semestre en el cuál el Alumno inscribió por última vez la Asignatura.
     * Puede no coincidir con el semestre regular en el cuál se está prevista inscriba/apruebe la materia.
     */
    private int semestreIncripcion;
    
    /**
     * Número de inscripciones que el Alumno hizo a esta asignatura antes de aprobarla.
     */
    private int inscripciones;
    
    /**
     * Método que crea una nueva instanca de AsignaturaInscrita vacía.
     */
    public AsignaturaInscrita() {
    }

    /**
     * Método que crea una nueva instancia de AsignaturaInscrita llena.
     * @param claveAsignatura El identificador de la Asignatura que el Alumno inscribió.
     * @param calificacionObtenida Calificación final que se le asentó al Alumno.
     * @param semestreIncripcion Número del semestre en el cuál el Alumno inscribió por última vez la Asignatura.
     * @param inscripciones Número de inscripciones que el Alumno hizo a esta asignatura antes de aprobarla.
     */
    public AsignaturaInscrita(String claveAsignatura, float calificacionObtenida, int semestreIncripcion, int inscripciones) {
        this.claveAsignatura = claveAsignatura;
        this.calificacionObtenida = calificacionObtenida;
        this.semestreIncripcion = semestreIncripcion;
        this.inscripciones = inscripciones;
    }

    /**
     * Método que devuelve la clave de la Asignatura que envuelve.
     * @return Una cadena, la clave de la Asignatura que envuelve.
     */
    public String getClaveAsignatura() {
        return claveAsignatura;
    }

    /**
     * Método que establece la clave de la Asignatura que envuelve.
     * @param claveAsignatura Una cadena, la clave de la Asignatura que envuelve.
     */
    public void setClaveAsignatura(String claveAsignatura) {
        this.claveAsignatura = claveAsignatura;
    }

    /**
     * Método que devuelve la última calificación obtenida en esta Asignatura por el Alumno.
     * @return Un número real entre 5.0 y 10.0, la última calificación obtenida por el Alumno en esta Asignatura.
     */
    public float getCalificacionObtenida() {
        return calificacionObtenida;
    }

    /**
     * Método que establece la última califiación obtenida en esta Asignatura por el Alumno.
     * @param calificacionObtenida La última calificación obtenida del Alumno.
     */
    public void setCalificacionObtenida(float calificacionObtenida) {
        this.calificacionObtenida = calificacionObtenida;
    }

    /**
     * Método que devuelve el número de semestres que han pasado desde que el Alumno inició la carrera donde inscribió por última vez la Asignatura.
     * @return Un número entero, el último semestre donde se inscribió la Asignatura.
     */
    public int getSemestreIncripcion() {
        return semestreIncripcion;
    }

    /**
     * Método que establece el número de semestres que han pasado desde que el Alumno inició la carrera donde inscribió por última vez la Asignatura.
     * @param semestreIncripcion Un número entero, el último semestre donde se inscribió la Asignatura.
     */
    public void setSemestreIncripcion(int semestreIncripcion) {
        this.semestreIncripcion = semestreIncripcion;
    }

    /**
     * Método que devuelve el número de veces que el Alumno ha inscrito la Asignatura para cursarla.
     * @return Un número entero, el número de veces que el Alumno ha inscrito la Asignatura.
     */
    public int getInscripciones() {
        return inscripciones;
    }

    /**
     * Método que establece el número de veces que el Alumno ha inscrito la Asignatura para cursarla.
     * @param inscripciones Un número entero, el número de veces que el Alumno ha inscrito la Asignatura.
     */
    public void setInscripciones(int inscripciones) {
        this.inscripciones = inscripciones;
    }    
}
