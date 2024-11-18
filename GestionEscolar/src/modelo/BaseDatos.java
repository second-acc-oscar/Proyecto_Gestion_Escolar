package modelo;

import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;
import modelo.AppClasses.Alumno;
import modelo.AppClasses.Asignatura;
import modelo.AppClasses.Usuario;

/**
 * Clase que representa a la base de datos de la aplicación.
 * 
 * En su responsabilidad contiene únicamente como atributos estructuras que almacenan el grueso de la información para la lógica de la aplicación, entre la que destaca:
 * <ul>
 *   <li>Registros de alumnos.</li>
 *   <li>Tira de materias de la facultad.</li>
 *   <li>Credenciales de ingreso al sistema.</li>
 *   <li>Nombres de alumnos. (CSV)</li>
 *   <li>Apellidos de alumnos. (CSV)</li>
 *   <li>Direcciones de alumnos. (CSV)</li>
 * </ul>
 * 
 * En la definición de sus métodos contiene únicamente aquellos necesarios para interactuar con dichas estructuras.
 *
 * @author Oscar Rojas
 */
public class BaseDatos {
    /**
     * Punto de acceso a la única instancia de BaseDatos.
     */
    private static final BaseDatos instance = new BaseDatos();
    
    /**
     * Lista que contiene la información de los posibles nombres de estudiantes leída en los archivos CSV.
     */
    private ArrayList<String> nombres = new ArrayList<String>();
    
    /**
     * Lista que contiene la información de los posibles apellidos de estudiantes leída en los archivos CSV.
     */
    private ArrayList<String> apellidos = new ArrayList<String>();
    
    /**
     * Lista que contiene la información de las posibles direcciones de etudiantes leída en los archivos CSV.
     */
    private ArrayList<String> direcciones = new ArrayList<String>();
    
    /**
     * Registros de todos los alumnos estudiantes ordinarios de la facultad.
     */
    private Hashtable<Integer, Alumno> alumnosOrdinarios = new Hashtable<Integer, Alumno>();
    
    /**
     * Registro de todos los alumnos FDU (fuera de usual) dados de alta en el sistema.
     * Los alumnos FDU, tal como se definen en el Documento 2: Requerimientos del Software, en TC07-NT01, son aquellos que cumplan al menos una de las siguientes condiciones:
     * <ol>
     *   <li>Se hayan dado de baja de la facultad, y por tanto ya no forman parte oficial de su alumnado activo..</li>
     *   <li>Hayan terminado la totalidad de los créditos de la facultad, y por consecuencia puedan ser llamados como egresados..<\li>
     * </ol>
     * Se entiende como alumnos FDU por sus siglas "Fuera De Usual".
     */
    private Hashtable<Integer, Alumno> alumnosFDU = new Hashtable<Integer, Alumno>();
    
    /**
     * Plan de estudios que contiene a los objetos de tipo asignatura de la facultad.
     */
    private Hashtable<Integer, Asignatura> planDeEstudios = new Hashtable<Integer, Asignatura>();
    
    /**
     * Usuarios dados de alta en el sistema para poder ingresar mediante sus credenciales.
     */
    private Hashtable<Integer, Usuario> usuarios = new Hashtable<Integer, Usuario>();
    
    /**
     * Crea una nueva instancia de BaseDatos vacía.
     * Visibilidad privada para la implementación del patrón de diseño Singleton.
     */
    private BaseDatos() {
        
    }
    
    /**
     * Método que devuelve la única instancia de la clase BaseDatos.
     * Implementación del patrón de diseño Singleton.
     */
    public static BaseDatos getInstance() {
        return instance;
    }
    
    /**
     * Método de uso general que indica el número de alumnos dados de alta en el sistema, utiliza el atributo {@code size} de la estructura que contiene a los alumnos, de manera que se mantiene dinámica en todo momento.
     * Indica el número de alumnos totales de la facultad a lo largo del tiempo. Ésto incluye tanto alumnos ordinarios como FDU.
     * @return El número de alumnos dados de alta en el sistema.
     */
    public int getNumAlumnos() {
        return alumnosOrdinarios.size() + alumnosFDU.size();
    }
    
    /**
     * Método de uso general que indica el número de alumnos <b>ordinarios</b> dados de alta en el sistema, utiliza el atributo {@code size} de la estructura que contiene a los alumnos, de manera que se mantiene dinámica en todo momento.
     * Indica el número de alumnos <b>ordinarios</b> dados de alta en la base de datos del sistema.
     * @return El número de alumnos ordinarios dados de alta en el sistema.
     */
    public int getNumAlumnosOrdinarios() {
        return alumnosOrdinarios.size();
    }
    
    /**
     * Método de uso general que indica el número de alumnos <b>FDU</b> dados de alta en el sistema, utiliza el atributo {@code size} de la estructura que contiene a los alumnos, de manera que se mantiene dinámica en todo momento.
     * Indica el número de alumnos <b>FDU</b> dados de alta en la base de datos del sistema.
     * @return El número de alumnos FUD dados de alta en el sistema.
     */
    public int getNumAlumnosFDU() {
        return alumnosFDU.size();
    }
    
    /**
     * Método que devuelve el número de posibles nombres para alumnos dados de alta en el sistema.
     * Utiliza el campo {@code size} de la estructura que contiene la información, asegurando que su consulta sea dinámica y actualizada en cualquier momento de uso.
     * @return El número de nombres dados de alta en el sistema.
     */
    public int getNumNombres() {
        return nombres.size();
    }
    
    /**
     * Método que devuelve el número de posibles apellidos para alumnos dados de alta en el sistema.
     * Utiliza el campo {@code size} de la estructura que contiene la información, asegurando que su consulta sea dinámica y actualizada en cualquier momento de uso.
     * @return El número de apellidos dados de alta en el sistema.
     */
    public int getNumApellidos() {
        return apellidos.size();
    }
    
    /**
     * Método que devuelve el número de posibles direcciones físicas para alumnos dadas de alta en el sistema.
     * Utiliza el campo {@code size} de la estructura que contiene la información, asegurando que su consulta sea dinámica y actualizada en cualquier momento de uso.
     * @return El número de direcciones físicas dadas de alta en el sistema.
     */
    public int getNumDirecciones() {
        return direcciones.size();
    }
    
    /**
     * Se utiliza principalmente en la inicialización de objetos de tipo Alumno.
     * El nombre que retorna es completamente aleatorio.
     * @return Uno de los nombres en la base de datos.
     */
    public String getNombreAleatorio() {
        Random rm = new Random();
        int idx = rm.nextInt( getNumNombres() );
        return nombres.get( idx );
    }
    
    /**
     * Se utiliza principalmente en la inicialización de objetos de tipo Alumno.
     * El apellido que retorna es completamente aleatorio.
     * @return Uno de los apellidos en la base de datos.
     */
    public String getApellidoAleatorio() {
        Random rm = new Random();
        int idx = rm.nextInt( getNumApellidos() );
        return apellidos.get( idx );
    }
    
    /**
     * Se utiliza principalmente en la inicialización de objetos de tipo Alumno.
     * La dirección física de domicilio es completamente aleatoria.
     * @return Una de las direccione de domicilio físicas en la base de datos.
     */
    public String getDireccionAleatoria() {
        Random rm = new Random();
        int idx = rm.nextInt( getNumDirecciones() );
        return direcciones.get( idx );
    }
    
    /**
     * Utilizado por la clase {@code Archivos} para inflar la información en la base de datos local de los posibles nombres para alumnos, según los archivos leídos.
     * @param nombre El nombre a añadir a la base de datos.
     */
    public void addNombre( String nombre ) {
        nombres.add( nombre );
    }
    
    /**
     * Utilizado por la clase {@code Archivos} para inflar la información en la base de datos local de los posibles apellidos para alumnos, según los archivos leídos.
     * @param apellido El apellido a añadir a la base de datos.
     */
    public void addApellido( String apellido ) {
        apellidos.add( apellido );
    }
    
    /**
     * Utilizado por la clase {@code Archivos} para inflar la información en la base de datos local de las posibles direccione de domicilio físicas para alumnos, según los archivos leídos.
     * @param direccion La dirección a añadir a la base de datos.
     */
    protected void addDireccion( String direccion ) {
        direcciones.add( direccion );
    }
    
    /**
     * Método que añade a la base de datos del sistema un nuevo alumno que es conocido de antemano como ordinario.
     * @param alumnoOrdinario El alumno a añadir a la base de datos.
     */
    public void addAlumnoOrdinario( Alumno alumnoOrdinario ) {
        alumnosOrdinarios.put( alumnoOrdinario.getNumeroDeCuenta(), alumnoOrdinario );
    }
    
    /**
     * Método que añade a la base de datos del sistema un nuevo alumno que es conocido de antemano como FDU.
     * @param alumnoFDU El alumno a añadir a la base de datos.
     */
    public void addAlumnoFDU( Alumno alumnoFDU ) {
        alumnosFDU.put( alumnoFDU.getNumeroDeCuenta(), alumnoFDU );
    }
    
    /**
     * Método que elimina de la base de datos a un alumno existente como ordinario.
     * @param numeroDeCuenta El número de cuenta del alumno a eliminar.
     * @return {@code true} si el alumno se encontraba entre los registros del sistema y se pudo borrar de ellos, {@code false} en caso contrario; el alumno no se encontraba en los registros del sistema.
     */
    public boolean deleteAlumnoOrdinario( int numeroDeCuenta ) {
        if( alumnosOrdinarios.containsKey( numeroDeCuenta ))
        {
            alumnosOrdinarios.remove( numeroDeCuenta );
            return true;
        }
        return false;
    }
    
    /**
     * Método que elimina de la base de datos a un alumno existente como FDU.
     * @param numeroDeCuenta El número de cuenta del alumno a eliminar.
     * @return {@code true} si el alumno se encontraba entre los registros del sistema y se pudo borrar de ellos, {@code false} en caso contrario; el alumno no se encontraba en los registros del sistema.
     */
    public boolean deleteAlumnoFDU( int numeroDeCuenta ) {
        if( alumnosFDU.containsKey( numeroDeCuenta ))
        {
            alumnosFDU.remove( numeroDeCuenta );
            return true;
        }
        return false;
    }
    
    /**
     * Método que busca el registro de un Alumno por su número de cuenta en la base de datos.
     * Es indistinta la condición ordinaria o FDU de un alumno, únicamente interesa saber si un registro identificable (número de cuenta) ya se encuentra ocupado por un alumno en la base de datos.
     * @param numeroDeCuenta El número de cuenta único del alumno que se quiere buscar.
     * @return {@code null} si el alumno no se encuentra en la base de datos, el objeto tipo de Alumno en caso de que sí se encuentre.
     */
    public Alumno buscarAlumno( int numeroDeCuenta ) {
        if( alumnosOrdinarios.containsKey( numeroDeCuenta ) )
        {
            return alumnosOrdinarios.get( numeroDeCuenta );
        }
        if( alumnosFDU.containsKey( numeroDeCuenta ) )
        {
            return alumnosFDU.get( numeroDeCuenta );
        }
        return null;
    }
}
