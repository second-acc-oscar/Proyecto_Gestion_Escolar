package vista;

import modelo.Archivos;
import modelo.BaseDatos;

/**
 * Clase principal que da inicio a la lógica de la aplicación.
 * @author Oscar Rojas
 */
public class Principal {
    public static void main(String[] args) {
        BaseDatos bd = BaseDatos.getInstance();
        Archivos.inicializarBaseDatosPlanDeEstudios( bd );
        Archivos.inicializarBaseDatosGeneracionAlumnos( bd );
    }
}
