package controlador;

import java.util.ArrayList;
import java.util.Collection;
import modelo.AppClasses.Alumno;
import modelo.AppClasses.AlumnoNumeroInscripcion;
import modelo.BaseDatos;
import modelo.AppClasses.Asignatura;
import modelo.AppClasses.Usuario;
import modelo.Archivos;

/**
 * Clase representante del controlador para el resto de la lógica del programa.
 * 
 * El Sistema se encarga de gestionar el flujo de peticiones que realiza el resto del programa para la interacción con la información en el modelo, y los requerimientos de la vista.
 * 
 * El resto de clases y módulos existentes en el controlador de la aplicación podrán ser únicamente accesibles por el Sistema.
 *
 * @author Oscar Rojas
 */
public class Sistema {
    /**
     * Instancia única de la base de datos. Requerida para realizar las peticiones.
     */
    private static BaseDatos bd = BaseDatos.getInstance();
    
    /**
     * Punto de acceso para inicializar la base de datos del Sistema a partir del sistema de Archivos.
     * Se inicializarán ciertos campos de la aplicación dependiendo si es un administrador el que está iniciando sesión, o un usuario.
     * @param paraAdmin Indica si se requiere inicializar la base de datos con la información que requiere un administrador.
     * @return {@code true} si no hubo ningún problema al inicializa base de datos, {@code false} en caso contrario.
     */
    public static boolean inicializarBaseDeDatos( boolean paraAdmin ) {
        if( paraAdmin )
            return Archivos.inicializarBaseDatosParaAdmin( bd );
        else
            return Archivos.inicializarBaseDatosParaUsuarios( bd );
    }
    
    public static void escribirArchivos( boolean paraAdmin ) {
        
    }

    /**
     * Interfaz que hace una petición a la base de datos para obtener un nombre cualquiera de los disponibles en la base de datos.
     * @return Una cadena con un nombre aleatorio.
     */
    public static String getNombreAleatorio() {
        return bd.getNombreAleatorio();
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener un apellido cualquiera de los disponibles en la base de datos.
     * @return Una cadena con un apellido aleatorio.
     */
    public static String getApellidoAleatorio() {
        return bd.getApellidoAleatorio();
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener una dirección de domicilio física cualquiera de las disponibles en la base de datos.
     * @return Una cade con un domicilio aleatorio.
     */
    public static String getDomicilioAleatorio() {
        return bd.getDireccionAleatoria();
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para buscar un alumno y, al mismo tiempo, comprobar si el alumno (su número de cuenta único y distinguible) ya tiene ese número de cuenta asociado.
     * @param numeroDeCuenta El identificador número de cuenta del Alumno que se quiere buscar.
     * @return {@code true} si el Alumno ya está dado de alta, {@code false} en caso contrario.
     */
    public static boolean existeAlumno( int numeroDeCuenta ) {
        return bd.buscarAlumno( numeroDeCuenta ) != null ? true : false;
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener el nombre de una asignatura de la que se conoce su clave única.
     * @param claveAsignatura La clave de la asignatura que se quiere buscar.
     * @return Una cadena con el nombre de la asignatura.
     */
    public static String getNombreAsignatura( String claveAsignatura ) {
        return bd.getNombreAsignatura( claveAsignatura );
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener el nombre de un Usuario.
     * @param claveUsuario Clave identificador del Usuario cuyo nombre se quiere obtener.
     * @return El nombre del Usuario si éste se mapea correctamente en la base de datos, o {@code null} en caso contrario.
     */
    public static String getNombreAcademico( String claveUsuario ) {
        if( bd.existeUsuario(claveUsuario) )
            return bd.getNombreUsuario( claveUsuario );
        else
            return null;
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener la instancia de Alumno asociada a un número de cuenta.
     * @param numeroDeCuenta El número de cuenta del Alumno buscado.
     * @return El Alumno asociado al número de cuenta, o {@code null} si no se encontró.
     */
    public static Alumno getAlumno( int numeroDeCuenta ) {
        return bd.getAlumno(numeroDeCuenta);
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener la contraseña de un Usuario.
     * @param claveUsuario Clave identificador del Usuario cuya contraseña se quiere obtener.
     * @return La contraseña del Usuario si éste se mapea correctamente en la base de datos, o {@code null} en caso contrario.
     */
    public static String getContrasenaAcademico( String claveUsuario ) {
        if( bd.existeUsuario( claveUsuario ) )
            return bd.getContrasenaAcademico( claveUsuario );
        else
            return null;
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para obtener al objeto de tipo Asignatura asociada a una valor clave de asignatura.
     * @param claveAsignatura La clave de la Asignatura que se quiere obtener.
     * @return El objeto de tipo Asignatura hallado, o {@code null} en caso de que no se haya encontrado.
     */
    public static Asignatura getAsignatura( String claveAsignatura ) {
        return bd.getAsignatura( claveAsignatura );
    }

    /**
     * Interfaz que hace una petición a la base de datos para saber si una clave está asociada efectivamente a un Usuario.
     * @param claveUsuario La clave que utiliza el Usuario para iniciar sesión.
     * @return {@code true} si hay un registro con esa clave, {@code false} en caso contrario.
     */
    public static boolean existeUsuario( String claveUsuario ) {
        return bd.existeUsuario( claveUsuario );
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para saber si una clave asociada efectiva
     * @param claveUsuario
     * @param contra
     * @return 
     */
    public static boolean coincideContrasena( String claveUsuario, String contra ) {
        return bd.coincideContrasena( claveUsuario, contra );
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para imprimirla información de todos los Usuarios (académicos) dados de alta en la base de datos.
     */
    public static void imprimirAcademicos() {
        bd.imprimirAcademicos();
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para añadir un nuevo Usuario a la base de datos.
     * @param usuario El objeto de tipo Usuario que se añadirá a la base de datos.
     */
    public static boolean agregarAcademico( Usuario usuario ) {
        return bd.addUsuario( usuario.getClave(), usuario);
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para modificar los campos de algún Usuario.
     * El proeso de modificación funciona destruyendo la instancia que existía del Usuario, y creando una nueva.
     * @param claveOriginalUsuario La clave que le pertenecía al Usuario que se quiere modificar.
     * @param usuarioModificado El objeto de tipo Usuario que reemplazará al que existía.
     */
    public static boolean modificarAcademico( String claveOriginalUsuario, Usuario usuarioModificado ) {
        if ( bd.deleteUsuario( claveOriginalUsuario ) )
        {
            bd.addUsuario( usuarioModificado.getClave(), usuarioModificado);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para eliminar a un Usuario.
     * @param claveUsuario La clave identificador del Usuario que se quiere borrar.
     * @return {@code true} si no hubo problemas al eliminarlo, {@code false} en caso contrario.
     */
    public static boolean eliminarAcademico( String claveUsuario ) {
        if( bd.existeUsuario( claveUsuario ) )
        {
            return bd.deleteUsuario( claveUsuario );
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para añadir un nuevo objeto de tipo Alumno a la base de datos.
     * @param alumno El Alumno que se quiere añadir a la base de datos.
     */
    public static void agregarAlumnoOrdinario( Alumno alumno ) {
        bd.addAlumnoOrdinario(alumno);
    }
    
    /**
     * Interfaz que hace una petición a la base de datos para imprimir en pantalla el historial de registro de inicio de sesión de la aplicación.
     */
    public static void verificarAccesos() {
        bd.imprimirRegistroAccesos();
    }
    
    /**
     * Método que crea y devuelve la lista de pares AlumnoNumeroInscripcion necesaria para realizar el cálculo del número de inscripción.
     * @return La lista de pares AlumnoNumeroInscripcion de alumnos ordinarios.
     */
    public static ArrayList<AlumnoNumeroInscripcion> getListaAlumnoNumeroInscripcion() {
        ArrayList<AlumnoNumeroInscripcion> lista = new ArrayList<AlumnoNumeroInscripcion>();
        Collection<Alumno> alumnos = bd.getAlumnosOrdinarios();
        
        for(Alumno alumno : alumnos) {
            lista.add( new AlumnoNumeroInscripcion( alumno.getNumeroDeCuenta(), alumno.getIndicadorEscolar() ) );
        }
        
        return lista;
    }
}
