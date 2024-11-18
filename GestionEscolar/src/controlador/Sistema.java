package controlador;

import modelo.BaseDatos;

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
}
