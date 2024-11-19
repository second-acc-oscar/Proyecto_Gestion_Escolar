package vista;

import modelo.AppClasses.PlanDeEstudios;
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
        Archivos.inicializarBaseDatosUsuarios( bd );
        System.out.println("Asignaturas: " + bd.getNumAsignaturas());
        System.out.println("Nombres: " + bd.getNumNombres());
        System.out.println("Apellidos: " + bd.getNumApellidos());
        System.out.println("Direcciones: " + bd.getNumDirecciones());
        System.out.println("Usuarios: " + bd.getNumUsuarios());
//        PlanDeEstudios.imprimir();
    }
}
