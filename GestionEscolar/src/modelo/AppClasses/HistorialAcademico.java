package modelo.AppClasses;

import controlador.Sistema;
import java.util.ArrayList;

/**
 * Clase que encapsula todas las Asignaturas que ha inscrito el Alumno y el desempeño que ha tenido en ellas.
 * Abstrae la información a partir de una colección de objetos de tipo {@code AsignaturaInscrita}.
 * @author Oscar Rojas
 */
public class HistorialAcademico {
    /**
     * Lista de las Asignaturas que ha inscrito el Alumno, sin importar si las ha pasado, o no.
     */
    ArrayList<AsignaturaInscrita> asignaturasInscritas = new ArrayList<AsignaturaInscrita>();
    
    /**
     * Método que computa el promedio general obtenido por el Alumno después de repasar todas las asignaturas que ha inscrito.
     * @return El promedio general del Alumno actualizado, en función de todas las asignaturas que ha inscrito.
     */
    public float getPromedioGeneral() {
        float promedio = 0.0f;
        int cursadas = 0;
        
        for( AsignaturaInscrita asig : asignaturasInscritas )
        {
            promedio += asig.getCalificacionObtenida();
            cursadas++;
        }
        promedio /= cursadas;
        
        return promedio;
    }
    
    /**
     * Método que computa el número de asignaturas inscritas por el Alumno desde que inició su carrera.
     * @return El número de asignatuas que el Alumno ha inscrito históricamente.
     */
    public int getAsignaturasInscritas() {
        return asignaturasInscritas.size();
    }
    
    /**
     * Método que computa el número de asignaturas inscritas por el Alumno después de repasar todas las asignaturas que ha inscrito.
     * @return El número de asignaturas aprobadas por el Alumno históricamente.
     */
    public int getAsignaturasAprobadas() {
        int aprobadas = 0;
        
        for( AsignaturaInscrita asig : asignaturasInscritas )
        {
            if ( asig.getCalificacionObtenida() >= 6.0f )
            {
                aprobadas++;
            }
        }
        
        return aprobadas;
    }
    
    /**
     * Método que imprime en pantalla de manera amigable para el usuario el historial académico del Alumno.
     */
    public void mostrar() {
        System.out.println("HISTORIAL ACADÉMICO");
        for( AsignaturaInscrita asig : asignaturasInscritas )
        {
            System.out.println("Asignatura:\t" + Sistema.getNombreAsignatura(asig.getClaveAsignatura())
                    + "\n\tCalificación:\t\t" + asig.getCalificacionObtenida()
                    + "\n\tSemestre inscrito:\t" + asig.getSemestreIncripcion()
                    + "\n\tInscripciones:\t\t" + asig.getInscripciones() );
        }
    }
    
    /**
     * Método que añade a la lista de asignaturas inscritas de un alumno, un objeto de tipo AsignaturaInscrita es específico.
     * @param asignatura 
     */
    public void addAsignatura( AsignaturaInscrita asignatura ) {
        asignaturasInscritas.add( asignatura );
    }
}
