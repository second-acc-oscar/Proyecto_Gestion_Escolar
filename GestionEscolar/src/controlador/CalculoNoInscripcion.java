package controlador;

import java.util.ArrayList;
import modelo.AppClasses.AlumnoNumeroInscripcion;

/**
 * Clase que se encarga de la lógica para calcular el número de inscripción.
 * @author Saúl Ojeda
 */
public class CalculoNoInscripcion {

    /**
     * Método que se encarga de realizar el cálculo y asignación del número de inscripción.
     * El cómputo se realiza a través del ordenamiento descendente de los Alumnos según su indicador escolar.
     * Para realizar el ordenamiento utiliza una implementación de QuickSort.
     * El ordenamiento debe ser de forma descendente ya que el Alumno con mejor rendimiento tendrá el mayor indicador escolar, y por lo tanto, el menor índice en toda la lista.
     * @param lista La lista de objetos par tipo AlumnoNumeroInscripcion necesaria para realizar el algoritmo.
     */
    public static void calcular( ArrayList<AlumnoNumeroInscripcion> lista ){
        iniciarQuickSort(lista, 0, lista.size()-1 );
    }
    
    /**
     * Método activador que da inicio a la primera llamada recursiva en la lógica del algoritmo de ordenamiento QuickSort para ordenar la lista de pares.
     * @param array La lista de pares de alumnos ordinarios.
     * @param low El índice cero (para la primera invocación al método), el primer elemento que debe ser ordenado en la partición original (lista completa) del ordenamiento.
     * @param high El último índice (para la primera invocación al método), el último elemento que debe ser ordenado en la partición original (lista completa) del ordenamiento.
     */
    private static void iniciarQuickSort( ArrayList<AlumnoNumeroInscripcion> array, int low, int high ) {
        quickSort(array, low, high);
        
        int i = 0;
        for( AlumnoNumeroInscripcion par : array ) {
            Sistema.getAlumno( par.getNumeroCuenta() ).setNumeroDeInscripcion( ++i );
        }
    }

    /**
     * Método que implementa el algoritmo de ordenamiento QuickSort.
     * Divide el arreglo en particiones, ordena cada partición de forma recursiva y combina los resultados para obtener un arreglo completamente ordenado.
     * El ordenamiento se realiza en base al atributo "indicador escolar" de los objetos AlumnoNumeroInscripcion en orden descendente.
     * 
     * @param array La lista de objetos AlumnoNumeroInscripcion que se desea ordenar.
     * @param low El índice inicial de la partición actual del arreglo que se está ordenando para esta llamada recursiva.
     * @param high El índice final de la partición actual del arreglo que se está ordenando para esta llamada recursiva.
     */
    private static void quickSort( ArrayList<AlumnoNumeroInscripcion> array, int low, int high ){
        int p;
        if(low < high){
            p = partition(array, low, high);
            quickSort(array, low, p-1);
            quickSort(array, p+1, high);
        }
    }

    /**
     * Método que realiza la partición de la lista durante el ordenamiento QuickSort.
     * Selecciona un elemento como pivote y reorganiza el arreglo de tal forma que todos los elementos mayores al pivote queden a su izquierda y todos los elementos menores o iguales al pivote queden a su derecha.
     * @param array La lista de objetos AlumnoNumeroInscripcion que se está ordenando.
     * @param low El índice inicial de la partición actual del arreglo.
     * @param high El índice final de la partición actual del arreglo. 
     *             El elemento en esta posición se usa como pivote.
     * @return El índice final del pivote después de la partición.
     */
    private static int partition( ArrayList<AlumnoNumeroInscripcion> array, int low, int high){
        double pivot = array.get(high).getIndicadorEscolar();
        int i = low-1;
        for(int j = low; j <= high-1; j++){
            if(array.get(j).getIndicadorEscolar() > pivot){
                i++;
                swap( array.get(i), array.get(j) );
            }
        }
        swap( array.get(i+1), array.get(high) );
        return i+1;
    }
    
    /**
     * Método auxiliar para el ordenamiento, intercambia dos objetos tipo par AlumnoNumeroInscripcion haciendo una deep copy de ellos.
     * Hacer una deep copy significa copiar todos los atributos de un objeto en el otro, y viceversa.
     * @param a1 El primer objeto tipo par que se quiere intercambiar.
     * @param a2 El segundo objeto tipo par que se quiere intercambiar.
     */
    private static void swap( AlumnoNumeroInscripcion a1, AlumnoNumeroInscripcion a2 ) {
        int tempInt = a1.getNumeroCuenta();
        double tempDouble = a1.getIndicadorEscolar();
        
        a1.setNumeroCuenta( a2.getNumeroCuenta() );
        a1.setIndicadorEscolar( a2.getIndicadorEscolar() );
        
        a2.setNumeroCuenta( tempInt );
        a2.setIndicadorEscolar( tempDouble );
    }
}
