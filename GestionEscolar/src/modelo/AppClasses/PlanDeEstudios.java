package modelo.AppClasses;

import controlador.Sistema;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene la información de las asignaturas dadas de alta en el sistema, categorizadas y agrupadas conforme número de semestre al que pertenecen.
 * @author Oscar Rojas
 */
public class PlanDeEstudios {
    /**
     * Lista con las claves de las asignaturas que corresponden al primer semestre de la carrera.
     */
    public static final ArrayList<String> PRIMER_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al segundo semestre de la carrera.
     */
    public static final ArrayList<String> SEGUNDO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al tercer semestre de la carrera.
     */
    public static final ArrayList<String> TERCER_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al cuarto semestre de la carrera.
     */
    public static final ArrayList<String> CUARTO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al quinto semestre de la carrera.
     */
    public static final ArrayList<String> QUINTO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al sexto semestre de la carrera.
     */
    public static final ArrayList<String> SEXTO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al séptimo semestre de la carrera.
     */
    public static final ArrayList<String> SEPTIMO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al octavo semestre de la carrera.
     */
    public static final ArrayList<String> OCTAVO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al noveno semestre de la carrera.
     */
    public static final ArrayList<String> NOVENO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista con las claves de las asignaturas que corresponden al décimo semestre de la carrera.
     */
    public static final ArrayList<String> DECIMO_SEMESTRE = new ArrayList<String>();
    
    /**
     * Lista que contiene de manera compacta cada una de las listas de semestres por individual.
     * Permite interactuar con todas las asignaturas de todos los semestres de manera optimizada, tratando con una sola estructura a la vez, ahorrando referenciar a cada una por individual cada vez que se quiera hacer algo con todas las asignaturas.
     */
    public static final List<List<String>> SEMESTRES = new ArrayList<>(List.of(
        PRIMER_SEMESTRE,
        SEGUNDO_SEMESTRE,
        TERCER_SEMESTRE,
        CUARTO_SEMESTRE,
        QUINTO_SEMESTRE,
        SEXTO_SEMESTRE,
        SEPTIMO_SEMESTRE,
        OCTAVO_SEMESTRE,
        NOVENO_SEMESTRE,
        DECIMO_SEMESTRE
    ));

    /**
     * Método que imprime de manera ordenada todo el plan de estudios de la carrera.
     * Ésto es, una por una todas las asignatuas.
     */
    public static void imprimir() {
        int i = 0;
        System.out.println("Plan de estudios, Ing. en Computación");
        for (List<String> semestre : SEMESTRES) {
            System.out.println("Semestre " + ++i);
            for (String clave : semestre) {
                System.out.println("\t" + Sistema.getNombreAsignatura(clave) + "  |  (" + clave + ")" );
            }
        }
    }
    
    /**
     * Método que agrega una asignatura a la base de datos de plan de estudios.
     * @param numeroSemestre El número del semestre al que pertenece la Asignatura a agregar.
     * @param claveAsignatura La clave única e identificable de la Asignatura que se va a añadir al plan de estudios.
     */
    public static void addAsignatura( int numeroSemestre, String claveAsignatura ) {
        switch( numeroSemestre ) {
            case 1 -> PRIMER_SEMESTRE.add( claveAsignatura );
            case 2 -> SEGUNDO_SEMESTRE.add( claveAsignatura );
            case 3 -> TERCER_SEMESTRE.add( claveAsignatura );
            case 4 -> CUARTO_SEMESTRE.add( claveAsignatura );
            case 5 -> QUINTO_SEMESTRE.add( claveAsignatura );
            case 6 -> SEXTO_SEMESTRE.add( claveAsignatura );
            case 7 -> SEPTIMO_SEMESTRE.add( claveAsignatura );
            case 8 -> OCTAVO_SEMESTRE.add( claveAsignatura );
            case 9 -> NOVENO_SEMESTRE.add( claveAsignatura );
            case 10 -> DECIMO_SEMESTRE.add( claveAsignatura );
        }
    }
    
    public static int getCreditosHastaSemestre( int numeroSemestre ) {
        int creditosAcumulados = 0;
        
        for( int i = 0; i < numeroSemestre; i++ )
        {
            for( String claveAsignatura : SEMESTRES.get(i) ) {
                creditosAcumulados += Sistema.getAsignatura(claveAsignatura).getCreditos();
            }
        }
        
        return creditosAcumulados;
    }
}
