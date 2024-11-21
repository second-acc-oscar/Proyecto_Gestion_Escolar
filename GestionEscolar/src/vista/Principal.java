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

        for(int i = 0; i < 100; i++ )
        {
            Alumno alumno;
            alumno = Alumno.generarAlumnoAleatorio();
            bd.addAlumnoOrdinario(alumno);
//            alumno.imprimirAlumno();
        }
        
        System.out.println("Alumnos: " + bd.getNumAlumnos());
        
        Sistema.imprimirAcademicos();
    }
}
