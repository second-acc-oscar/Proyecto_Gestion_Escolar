package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import modelo.AppClasses.Asignatura;
import modelo.AppClasses.Usuario;
import modelo.BaseDatos;

/**
 * Clase que se encarga de la lógica para leer y escribir la información de la base de datos.
 * 
 * Como propósito general tiene:
 * <ul>
 *   <li>Traducir la información de los archivos físicos a las estructuras manipulables dentro de la lógica del programa.</li>
 *   <li>Asegurar la perduración de la información manipulada tras las ejecuciones.</li>
 *   <li>Sincronizar la base de datos física con su implementación en clases tras cada ejecución.</li>
 *   <li>Cargar los archivos físicos a la base de datos cada vez que se inicie la aplicacón.</li>
 *   <li>Escribir los archivos físicos desde la base de datos al terminar de utilizar la aplicación.</li>
 * </ul>
 * 
 * Su interacción debe de ser estrecha con la base de datos y únicamente con la base de datos, con excepción del Sistema.
 * 
 * Los métodos que contiene son para llevar a cabo lo fines descritos.
 * 
 * No contiene atributos de mayor trascendencia o relevancia.
 * 
 * @author Oscar Rojas
 */
public class Archivos {
    /**
     * Instancia única de la base de datos. Requerida para incializarla.
     */
    private static BaseDatos db = BaseDatos.getInstance();
    
    /**
     * Extensión utilizada para los archivos estándar en la base de datos.
     */
    private static final String EXTENSION = ".txt";
    /**
     * Ruta en los archivos del proyecto donde se encuentra el archivos de nombres. Se requiere para su lectura. (files/csv/nombres.csv)
     */
    private static final String RUTA_NOMBRES = "files/csv/nombres.csv";
    /**
     * Ruta en los archivos del proyecto donde se encuentra el archivos de apellidos. Se requiere para su lectura. (files/csv/apellidos.csv)
     */
    private static final String RUTA_APELLIDOS = "files/csv/apellidos.csv";
    /**
     * Ruta en los archivos del proyecto donde se encuentra el archivos de direcciones de domicilio físicas. Se requiere para su lectura. (files/csv/direcciones.csv)
     */
    private static final String RUTA_DIRECCIONES = "files/csv/direcciones.csv";
    /**
     * Ruta en los archivos del proyecto donde se encuentra la lista de asignaturas que se deben de leer como objeto.
     */
    private static final String RUTA_ASIGNATURAS = "files/materias/";
    /**
     * Ruta <b>general</b> en los archivos del proyecto donde se encuentran cada uno de las asignaturas del plan de estudios de la carrera en la facultad.
     */
    private static final String RUTA_ASIGNATURAS_ORIGINAL = "files/materias/asignaturas.txt";
    /**
     * Ruta en los arhcivos del proyecto donde se encuentra la lista de usuarios que tienen credenciales válidas para iniciar sesión en el sistema.
     */
    private static final String RUTA_USUARIOS = "files/usuarios/";
    /**
     * Ruta <b>general</b> en los archivos del proyecto donde se encuentren cada uno de los registros de las credenciales que tienen acceso a la aplicación.
     */
    private static final String RUTA_USUARIOS_ORIGINAL = "files/usuarios/usuarios.txt";
    
    /**
     * Método que infla la base de datos en su campo de Usuarios dados de alta en el sistema a través de la implementación de base de datos en archivos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    public static boolean inicializarBaseDatosUsuarios( BaseDatos bd ) {
        try {
            leerUsuarios( bd );
        } catch (Exception e) {
            System.out.println("Error al inicializar la base de datos.");
            System.out.println( e.getMessage() );
            return false;
        }
        return true;
    }
    
    /**
     * Método que lee individualmente cada objeto de tipo usuario mediante la dirección donde se encuentran todos los usuarios registrados.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    private static void leerUsuarios( BaseDatos bd ) throws IOException {
        String nullArchive = RUTA_USUARIOS + "null" + EXTENSION;
        try ( FileReader fr = new FileReader( RUTA_USUARIOS_ORIGINAL ); BufferedReader br = new BufferedReader( fr ) ) {
            String fileContent = RUTA_USUARIOS;
            fileContent += br.readLine();
            fileContent += EXTENSION;
            while( ! nullArchive.equals( fileContent ) )
            {
                Archivos.leerUsuario( bd, fileContent );
                fileContent = RUTA_USUARIOS;
                fileContent += br.readLine();
                fileContent += EXTENSION;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer los usuarios de la ruta original.");
            throw new IOException( e );
        }
    }
    
    /**
     * Lee individualmente todos los campos de un Usuario registrado previamente.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @param fileName Nombre del archivo en el cual se encuentra la información del Usuario a inflar.
     * @throws IOException 
     */
    private static void leerUsuario( BaseDatos bd, String fileName ) throws IOException {
        try ( FileReader fr = new FileReader ( fileName ); BufferedReader br = new BufferedReader( fr ) ) {
            Usuario usuario = new Usuario();
            
            usuario.setNombreUsuario( br.readLine() );
            usuario.setClave( br.readLine() );
            usuario.setPassword( br.readLine() );
            
            bd.addUsuario( usuario.getClave(), usuario);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer el usuario: " + fileName );
            throw new IOException( e );
        }
    }
    
    /**
     * Método que se encarga de cargar en la base de datos local la información del plan de estudios.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    public static boolean inicializarBaseDatosPlanDeEstudios( BaseDatos bd ) {
        try {
            leerAsignaturas( db );
        } catch ( Exception e) {
            System.out.println("Error al inicializar la base de datos.");
            System.out.println( e.getMessage() );
            return false;
        }
        return true;
    }
    
    /**
     * Método que se encarga de inicializar todas las asignaturas guardadas en la base de datos implementada mediante archivos. Inicializa una por una todas las asignaturas.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException Error al leer los archivos, e.g. al momento de leer un archivo de asignatura.
     */
    private static void leerAsignaturas( BaseDatos bd ) throws IOException {
        String nullArchive = RUTA_ASIGNATURAS + "null" + EXTENSION;
        try ( FileReader fr = new FileReader( RUTA_ASIGNATURAS_ORIGINAL ); BufferedReader br = new BufferedReader( fr ) ) {
            String fileContent = RUTA_ASIGNATURAS;
            fileContent += br.readLine();
            fileContent += EXTENSION;
            while( ! nullArchive.equals( fileContent ) )
            {
                Archivos.leerAsignatura( bd, fileContent );
                fileContent = RUTA_ASIGNATURAS;
                fileContent += br.readLine();
                fileContent += EXTENSION;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer las asignaturas desde la ruta original.");
            throw new IOException( e );
        }
    }
    
    /**
     * Se encarga de inicializar completamente un único objeto de tipo Asignatura a partir de la información de la misma en su archivo correspondiente.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @param fileName El nombre del archivo en el cuál se encuentra la información de la asignatura en específico.
     * @throws IOException Error al leer los archivos, e.g. no se encuentra el archivo de la asignatura.
     */
    private static void leerAsignatura( BaseDatos bd, String fileName ) throws IOException {
        try ( FileReader fr = new FileReader( fileName ); BufferedReader br = new BufferedReader( fr ) ) {
            Asignatura asignatura = new Asignatura();
            
            asignatura.setNombre( br.readLine() );
            asignatura.setClave( br.readLine() );
            asignatura.setCreditos( Integer.parseInt( br.readLine() ) );
            asignatura.setHorasTotales( Integer.parseInt( br.readLine() ) );
            asignatura.setSemestre( Integer.parseInt( br.readLine() ) );
            asignatura.setSeriacionAntecedente( br.readLine() );
            asignatura.setSeriacionSubsecuente( br.readLine() );
            asignatura.setObjetivo( br.readLine() );
            
            bd.addAsignatura( asignatura.getClave(), asignatura);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer la asignatura: " + fileName );
            throw new IOException( e );
        }
    }
    
    /**
     * Método utilizado al iniciar la aplicación para inflar los atributos de la base de datos necesarios para la lógica de la aplicación.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    public static boolean inicializarBaseDatosGeneracionAlumnos( BaseDatos bd ) {
        try {
            leerNombres( db );
            leerApellidos( db );
            leerDirecciones( db );
        } catch ( IOException e ) {
            System.out.println("Error al incializar la base de datos.");
            System.out.println( e.getMessage() );
            return false;
        }
        return true;
    }
    
    /**
     * Abre el archivo "files/csv/nombres.csv" para leer cada uno de los nombres en él e inicializar la base de datos con ellos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException Error al leer los archivos, e.g. al momento de leer los nombres o apellidos.
     */
    private static void leerNombres( BaseDatos bd ) throws IOException {
        try ( FileReader fr = new FileReader( RUTA_NOMBRES ); BufferedReader br = new BufferedReader( fr ) ) {            
            String fileContent = br.readLine();
            while( fileContent != null )
            {
                bd.addNombre( fileContent );
                fileContent = br.readLine();
            }
        } catch ( IOException e ) {
            System.out.println( "Ha ocurrido un error al leer los nombres dede la ruta original." );
            throw new IOException( e );
        }
    }
    
    /**
     * Abre el archivo "files/csv/apellidos.csv" para leer cada uno de los apellidos en él e inicializar la base de datos con ellos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException Error al leer los archivos, e.g. al momento de leer los nombres o apellidos.
     */
    private static void leerApellidos( BaseDatos bd ) throws IOException {
        try ( FileReader fr = new FileReader( RUTA_APELLIDOS ); BufferedReader br = new BufferedReader( fr )) {
            String fileContent = br.readLine();
            while( fileContent != null ) {
                StringTokenizer tokenizador = new StringTokenizer( fileContent, ",");
                while( tokenizador.hasMoreTokens() )
                {
                    bd.addApellido( tokenizador.nextToken() );
                }
                fileContent = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer los apellidos desde la ruta original.");
            throw new IOException( e );
        }
    }

    /**
     * Abre el archivo "files/csv/direcciones.csv" para leer cada uno de las direcciones en él e inicializar la base de datos con ellas.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException Error al leer los archivos, e.g. no se encontró el archivo en la ruta especificada.
     */
    private static void leerDirecciones( BaseDatos bd ) throws IOException {
        try ( FileReader fr = new FileReader( RUTA_DIRECCIONES ); BufferedReader br = new BufferedReader( fr )) {
            String fileContent = br.readLine();
            while( fileContent != null )
            {
                bd.addDireccion( fileContent );
                fileContent = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer las direcciones físicas desde la ruta original.");
            throw new IOException( e );
        }
    }
}
