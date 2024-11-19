package modelo.AppClasses;

import controlador.Sistema;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene la información de las asignaturas dadas de alta en el sistema, categorizadas y agrupadas conforme número de semestre al que pertenecen.
 * @author Oscar Rojas
 */
public class PlanDeEstudios {
    public static final ArrayList<String> PRIMER_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> SEGUNDO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> TERCER_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> CUARTO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> QUINTO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> SEXTO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> SEPTIMO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> OCTAVO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> NOVENO_SEMESTRE = new ArrayList<String>();
    public static final ArrayList<String> DECIMO_SEMESTRE = new ArrayList<String>();
    
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
    
    public static void imprimir() {
        int i = 0;
        for (List<String> semestre : SEMESTRES) {
            System.out.println("Semestre " + ++i);
            for (String clave : semestre) {
                System.out.println("\t" + Sistema.getNombreAsignatura(clave) + "  |  (" + clave + ")" );
            }
        }
    }
    
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
}
