package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
     * Método utilizado al iniciar la aplicación para inflar los atributos de la base de datos necesarios para la lógica de la aplicación.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    public static boolean inicializarBaseDatos( BaseDatos bd ) {
        try {
            leerNombres( db );
            leerApellidos( db );
            leerDirecciones( db );
            System.out.println("Nombres:" + bd.getNumNombres() );
            System.out.println("Apellidos:" + bd.getNumApellidos() );
            System.out.println("Direcciones: " + bd.getNumDirecciones() );
        } catch ( IOException e ) {
            System.out.println("Error al incializar la base de datos.");
            System.out.println( e.getMessage() );
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
