package controlador;

import modelo.BaseDatos;
import modelo.AppClasses.Asignatura;
import modelo.AppClasses.Usuario;

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
}
