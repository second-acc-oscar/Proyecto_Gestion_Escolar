package vista;

import controlador.Sistema;
import modelo.AppClasses.Alumno;
import modelo.AppClasses.PlanDeEstudios;
import modelo.Archivos;
import modelo.BaseDatos;

/**
 * Clase principal que ejecuta mediante el método principal la lógica del programa para la ejecución de la aplicación.
 * @author Oscar Rojas
 */
public class Principal {
    /**
     * Método principal que da inicio a la lógica de la aplicación.
     * @param args Argumentos en la línea de comandos.
     */
    public static void main(String[] args) {
        
        Login.iniciar();
    }
}
