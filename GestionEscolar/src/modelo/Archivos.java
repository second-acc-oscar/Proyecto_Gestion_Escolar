package modelo.data_base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private BaseDatos db = BaseDatos.getInstance();
    
    private static final String RUTA = "files/csv/prueba.txt";
    private static final String CONTENIDO = "Hola, soy contenido de prueba.\n";
    
    public static boolean inicializarBaseDatos( BaseDatos bd ) {
        escribirCSV();
        
        return true;
    }
    
    private void leerNombres( BaseDatos bd ) {
        try {
            FileReader fr = new FileReader( RUTA );
            BufferedReader br = new BufferedReader(fr);
            System.out.println("###");
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while(linea != null )
            {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.out.println( e.getMessage() );
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Escrbiendo archivo.");
        Archivos.inicializarBaseDatos( BaseDatos.getInstance() );
    }
    
    private static void escribirCSV() {
        try {
            FileWriter fw = new FileWriter( RUTA ); // Si no existe el archivo, se crea. Si sì existe, se sobreescribe
            BufferedWriter bw = new BufferedWriter( fw );
            PrintWriter salida = new PrintWriter( bw );
            salida.println( CONTENIDO );
            salida.close();
        } catch (IOException e) {
            System.out.println( e.getMessage() );
        }
    }
}
