package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.StringTokenizer;
import modelo.AppClasses.Alumno;
import modelo.AppClasses.Asignatura;
import modelo.AppClasses.AsignaturaInscrita;
import modelo.AppClasses.HistorialAcademico;
import modelo.AppClasses.PlanDeEstudios;
import modelo.AppClasses.RegistroLogin;
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
     * Ruta en los archivos del proyecto donde se encuentra el archivo de consulta CSV para alumnos. (files/csv/alumnos.csv)
     */
    private static final String RUTA_ALUMNOS_CSV = "files/csv/alumnos.csv";
    
    /**
     * Ruta en los archivos del proyecto donde se encuentra la lista de asignaturas que se deben de leer como objeto. (files/materias/)
     */
    private static final String RUTA_ASIGNATURAS = "files/materias/";
    
    /**
     * Ruta <b>general</b> en los archivos del proyecto donde se encuentran cada uno de las asignaturas del plan de estudios de la carrera en la facultad. (files/materias/asignaturas.txt)
     */
    private static final String RUTA_ASIGNATURAS_ORIGINAL = "files/materias/asignaturas.txt";
    
    /**
     * Ruta en los archivos del proyecto donde se encuentra la lista de usuarios que tienen credenciales válidas para iniciar sesión en el sistema. (files/usuarios/)
     */
    private static final String RUTA_USUARIOS = "files/usuarios/";
    
    /**
     * Ruta <b>general</b> en los archivos del proyecto donde se encuentren cada uno de los registros de las credenciales que tienen acceso a la aplicación. (files/usuarios/usuarios.txt)
     */
    private static final String RUTA_USUARIOS_ORIGINAL = "files/usuarios/usuarios.txt";
    
    /**
     * Ruta en los archivos del proyecto donde se encuentra la lista de alumnos que tienen una cuenta en el sistema. (files/alumnos/)
     */
    private static final String RUTA_ALUMNOS = "files/alumnos/";
    
    /**
     * Ruta <b>general</b> en los archivos del proyecto donde se encuentran cada uno de los registros de los alumnos que tienen una cuenta en el sistema. (files/alumnos/alumnos.txt)
     */
    private static final String RUTA_ALUMNOS_ORIGINAL = "files/alumnos/alumnos.txt";
    
    /**
     * Ruta en los archivos del proyecto donde se encuentra la lista de registros de inicios de sesión al sistema. (files/usuarios/registro.txt)
     */
    private static final String RUTA_REGISTROS_LOGIN = "files/usuarios/registro.txt";
    
    /**
     * Método que inicializa únicamente los usuarios a partir de archivos.
     */
    public static void inicializarUsuarios() {
        inicializarBaseDatosUsuarios( db );
    }
    
    /**
     * Inicializa la base de datos del sistema con la información que necesita la lógica del programa cuando inicia sesión el <b>administrador</b>.
     * La información que inicializa de archivos incluye:
     * <ul>
     *   <li>Registro de inicios de sesión en el Sistema.</li>
     *   <li>Credenciales de acceo de Usuarios.</li>
     * </ul>
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si se pudo inicializar correctamente la información necesaria, {@code false} en caso contrario.
     */
    public static boolean inicializarBaseDatosParaAdmin( BaseDatos bd ) {
        boolean noHuboProblemas;
        noHuboProblemas = inicializarBaseDatosUsuarios( bd );
        if( ! noHuboProblemas )
            return false;
        noHuboProblemas = inicializarBaseDatosRegistrosLogin( bd );
        if( ! noHuboProblemas )
            return false;
        return true;
    }
    
    /**
     * Método que actualiza la implementación de la base de datos en archivos con la nueva información actualizada durante la ejecución de un programa.
     * Se ejecuta el terminar una ejecución del programa.
     * Se considera como ejecucíón del programa un deslgueo del usuario Administrador.
     * 
     * Realiza la escritura de la base de datos para los Usuarios.
     * @param bd Instancia única de la base de datos. Requerida para leerla.
     */
    public static void escribirBaseDatosParaAdmin( BaseDatos bd ) {
        try ( FileWriter fw = new FileWriter( RUTA_USUARIOS_ORIGINAL ); BufferedWriter bw = new BufferedWriter( fw ); PrintWriter salida = new PrintWriter( bw ) ) {
            for( Usuario usuario : bd.getUsuarios() )
            {
                salida.println( usuario.getClave() );
            }
            
            escribirUsuarios( bd.getUsuarios() );
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido al escribir la base de datos para Administrador.");
            System.out.println( e.getMessage() );
        }
    }
    
    /**
     * Método que escribe cada uno de los archivos de usuarios, para cada Usuario dado de alta en la base de datos al momento de finalizar una ejecución.
     * @param usuarios Una colección con todos los objetos de tipo Usuario dados de alta en la base de datos.
     * @throws IOException Si ocurrió algún error al trabajar con los archivos de usuario.
     */
    private static void escribirUsuarios( Collection<Usuario> usuarios ) throws IOException {
        String fileName;
        for( Usuario usuario : usuarios )
        {
            fileName = RUTA_USUARIOS + usuario.getClave() + EXTENSION;
            try( FileWriter fw = new FileWriter( fileName ); BufferedWriter bw = new BufferedWriter( fw ); PrintWriter salida = new PrintWriter( bw ) ) {
                salida.println( usuario.toFile() );
            } catch ( IOException e ) {
                System.out.println("Ha ocurrido un error al escribir el archivo: " + fileName );
                throw new IOException( e );
            }
        }
    }
    
    /**
     * Método que actualiza la implementación de la base de datos en archivos con la nueva información actualizada durante la ejecución de un programa.
     * Se ejecuta el terminar una ejecución del programa.
     * Se considera como ejecucíón del programa un deslgueo del Usuario que haya accedido.
     * 
     * Realiza la escritura de la base de datos para los Alumnos.
     * @param bd Instancia única de la base de datos. Requerida para leerla.
     */
    public static void escribirBaseDatosParaUsuario( BaseDatos bd ) {
        try ( FileWriter fw = new FileWriter( RUTA_ALUMNOS_ORIGINAL ); BufferedWriter bw = new BufferedWriter( fw ); PrintWriter salida = new PrintWriter( bw ) ) {
            for( Alumno alumno : bd.getAlumnosOrdinarios() )
            {
                salida.println( alumno.getNumeroDeCuenta() );
            }
            
            escribirAlumnos( bd.getAlumnosOrdinarios() );
            escribirAlumnosCSV( bd.getAlumnosOrdinarios() );
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido al escribir la base de datos para Usuario.");
            System.out.println( e.getMessage() );
        }
    }
    
    /**
     * Método que escribe cada uno de los archivos de alumnos, para cada Alumno dado de alta en la base de datos al momento de finalizar una ejecución.
     * @param alumnos Una colección con todos los objetos de tipo Alumno dados de alta en la base de datos.
     * @throws IOException Si ocurrió algún error al trabajar con los archivos de alumnos.
     */
    private static void escribirAlumnos( Collection<Alumno> alumnos ) throws IOException {
        String fileName;
        for( Alumno alumno : alumnos )
        {
            fileName = RUTA_ALUMNOS + alumno.getNumeroDeCuenta() + EXTENSION;
            try( FileWriter fw = new FileWriter( fileName ); BufferedWriter bw = new BufferedWriter( fw ); PrintWriter salida = new PrintWriter( bw ) ) {
                salida.println( alumno.getNombre() );
                salida.println( alumno.getApellidoPaterno() );
                salida.println( alumno.getApellidoMaterno() );
                salida.println( alumno.getNumeroDeCuenta() );
                salida.println( alumno.getDomicilio() );
                salida.println( alumno.getCorreo() );
                salida.println( alumno.getPromedioGeneral() );
                salida.println( alumno.getEdad() );
                salida.println( alumno.getSemestreRegular() );
                salida.println( alumno.getAsignaturasInscritas() );
                salida.println( alumno.getAsignaturasAprobadas() );
                salida.println( alumno.getNumeroDeInscripcion() );
                
                for( AsignaturaInscrita asignatura : alumno.getHistorialAcademico().getAsignaturasHistorialAcademico() )
                {
                    salida.println( asignatura.toCSV() );
                }
            } catch ( IOException e ) {
                System.out.println("Ha ocurrido un error al escribir el archivo: " + fileName );
                throw new IOException( e );
            }
        }
    }
    
    /**
     * Método que sobreescribe el registro de Alumnos en formato CSV.
     * @param alumnos Una Collection con todos los objetos de tipo Alumno en la base de datos.
     * @throws IOException Si ocurrió algún error al trabajar con el archivo de alumnos CSV.
     */
    private static void escribirAlumnosCSV( Collection<Alumno> alumnos ) throws IOException {
        try( FileWriter fw = new FileWriter( RUTA_ALUMNOS_CSV ); BufferedWriter bw = new BufferedWriter( fw ); PrintWriter salida = new PrintWriter( bw ) ) {
            for( Alumno alumno : alumnos )
            {
                salida.println( alumno.toCSV() );
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al escribir el archivo alumnos CSV.");
            throw new IOException( e );
        }
    }
    
    /**
     * Método que añade el registro de un inicio de sesión al archivo de registros de inicio de sesión.
     * @param login El objeto RegistroSesion que encapsula la información del inicio de sesión.
     */
    private static void escribirNuevoLogin( RegistroLogin login ) {
        try( FileWriter fw = new FileWriter( RUTA_REGISTROS_LOGIN, true ); BufferedWriter bw = new BufferedWriter(fw); PrintWriter salida = new PrintWriter(bw) ) {
            salida.println( login.toCSV() );
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al escribir un registro login.");
        }
    }
    
    /**
     * Inicializa la base de datos del sistema con la información que necesita la lógica del programa cuando inicia sesión algún <b>usuario</b>.
     * La información que inicializa de archivos incluye:
     * <ul>
     *   <li>Plan de estudios de la carrera.</li>
     *   <li>Nombres genéricos.</li>
     *   <li>Apellidos genéricos.</li>
     *   <li>Direcciones de domiclio genéricas.</li>
     *   <li>Registros de todos los alumnos en el Sistema.</li>
     * </ul>
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si se pudo inicializar correctamente la información necesaria, {@code false} en caso contrario.
     */
    public static boolean inicializarBaseDatosParaUsuarios( BaseDatos bd ) {
        boolean noHuboProblemas;
        noHuboProblemas = inicializarBaseDatosPlanDeEstudios( bd );
        if( ! noHuboProblemas )
            return false;
        noHuboProblemas = inicializarBaseDatosGeneracionAlumnos( bd );
        if( ! noHuboProblemas )
            return false;
        noHuboProblemas = inicializarBaseDatosAlumnos( bd );
        if( ! noHuboProblemas )
            return false;
        return true;
    }
    
    /**
     * Método que infla la base de datos con la información de los alumnos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si se pudo inicializar correctamente la información necesaria, {@code false} en caso contrario.
     */
    private static boolean inicializarBaseDatosAlumnos( BaseDatos bd ) {
        try {
            leerAlumnos( bd );
        } catch (Exception e) {
            System.out.println("Error al inicializar la base de datos.");
            System.out.println( e.getMessage() );
            return false;
        }
        return true;
    }
    
    /**
     * Método que se encarga de inicializar todos los alumnos guardados en la base de datos implementada mediante archivos. Inicializa uno por uno todos los alumnos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @throws IOException Error al leer los archivos, e.g. al momento de leer un archivo de alumno.
     */
    private static void leerAlumnos( BaseDatos bd ) throws IOException {
        String nullArchive = RUTA_ALUMNOS + "null" + EXTENSION;
        try ( FileReader fr = new FileReader( RUTA_ALUMNOS_ORIGINAL ); BufferedReader br = new BufferedReader( fr ) ) {
            String fileContent = RUTA_ALUMNOS;
            fileContent += br.readLine();
            fileContent += EXTENSION;
            while( ! nullArchive.equals( fileContent ) )
            {
                Archivos.leerAlumno( bd, fileContent );
                fileContent = RUTA_ALUMNOS;
                fileContent += br.readLine();
                fileContent += EXTENSION;
            }
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al leer los alumnos de la ruta original.");
            throw new IOException( e );
        }
    }
    
    /**
     * Se encarga de inicializar completamente un único objeto de tipo Alumno a partir de la información de la misma en su archivo correspondiente.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @param fileName El nombre del archivo en el cuál se encuentra la información del alumno en específico.
     * @throws IOException Error al leer los archivos, e.g. no se encuentra el archivo del alumno.
     */
    private static void leerAlumno( BaseDatos bd, String fileName ) throws IOException {
        try ( FileReader fr = new FileReader ( fileName ); BufferedReader br = new BufferedReader( fr ) ) {
            Alumno alumno = new Alumno();
            HistorialAcademico historialAcademico = new HistorialAcademico();
            
            alumno.setNombre( br.readLine() );
            alumno.setApellidoPaterno( br.readLine() );
            alumno.setApellidoMaterno( br.readLine() );
            alumno.setNumeroDeCuenta( br.read() );
            alumno.setDomicilio( br.readLine() );
            alumno.setCorreo( br.readLine() );
            alumno.setPromedioGeneral( Float.parseFloat( br.readLine() ) );
            alumno.setEdad( br.read() );
            alumno.setSemestreRegular( br.read() );
            alumno.setAsignaturasInscritas( br.read() );
            alumno.setAsignaturasAprobadas( br.read() );
            alumno.setNumeroDeInscripcion( br.read() );
            
            String asignaturaInscrita = br.readLine();
            while( asignaturaInscrita != null )
            {                
                StringTokenizer tokenizador = new StringTokenizer( asignaturaInscrita, ",");
                AsignaturaInscrita asig = new AsignaturaInscrita( tokenizador.nextToken(), Float.parseFloat(tokenizador.nextToken()) , Integer.parseInt(tokenizador.nextToken()), Integer.parseInt(tokenizador.nextToken()) );
                
                asignaturaInscrita = br.readLine();
                historialAcademico.addAsignatura( asig );
            }
            
//            alumno.imprimirAlumno(); // <--- Impresión del Alumno según se lee de archivos
            bd.addAlumnoOrdinario( alumno );
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al leer el alumno: " + fileName );
            throw new IOException( e );
        }
    }
    
    /**
     * Método que infla la base de datos con la información de los registros de inicio de sesión existentes en archivos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} en caso de que se inicilizara sin problemas, {@code false} en caso contrario.
     */
    private static boolean inicializarBaseDatosRegistrosLogin( BaseDatos bd ) {
        try {
            leerRegistrosLogin( bd );
        } catch ( IOException e ) {
            System.out.println("Error al inicializar la base de datos.");
            System.out.println( e.getMessage() );
            return false;
        }
        return true;
    }
    
    /**
     * Mëtodo que lee todos los registros al sistema que han habido y los almacena en la base de datos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} en caso contrario.
     */
    private static boolean leerRegistrosLogin( BaseDatos bd ) throws IOException {
        try (FileReader fr = new FileReader( RUTA_REGISTROS_LOGIN ); BufferedReader br = new BufferedReader(fr) ) {
            String fileContent;
            fileContent = br.readLine();
            
            while( fileContent != null )
            {
                StringTokenizer tokenizador = new StringTokenizer( fileContent, ",");

                RegistroLogin login = new RegistroLogin( tokenizador.nextToken(), LocalDate.parse( tokenizador.nextToken() ), LocalTime.parse( tokenizador.nextToken() ) );
                
                fileContent = br.readLine();
                bd.addRegistroLogin( login );
            }
        } catch ( IOException e ) {
            System.out.println("Error al leer los registros de inicio de sesión.");
            throw new IOException(e);
        }
        return true;
    }
    
    /**
     * Método que infla la base de datos en su campo de Usuarios dados de alta en el sistema a través de la implementación de base de datos en archivos.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    private static boolean inicializarBaseDatosUsuarios( BaseDatos bd ) {
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
        } catch ( IOException e ) {
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
            
//            usuario.imprimirUsuario(); // <--- Impresión del usuario según se lee de archivos
            bd.addUsuario( usuario.getClave(), usuario);
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al leer el usuario: " + fileName );
            throw new IOException( e );
        }
    }
    
    /**
     * Método que se encarga de cargar en la base de datos local la información del plan de estudios.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    private static boolean inicializarBaseDatosPlanDeEstudios( BaseDatos bd ) {
        try {
            leerAsignaturas( db );
        } catch ( IOException e ) {
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
        } catch ( IOException e ) {
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
            
//            asignatura.imprimirAsignatura(); // <--- Impresión de la asignatura según se lee de archivos
            PlanDeEstudios.addAsignatura( asignatura.getSemestre(), asignatura.getClave() );
            bd.addAsignatura( asignatura.getClave(), asignatura);
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al leer la asignatura: " + fileName );
            throw new IOException( e );
        }
    }
    
    /**
     * Método utilizado al iniciar la aplicación para inflar los atributos de la base de datos necesarios para la lógica de la aplicación.
     * @param bd Instancia única de la base de datos. Requerida para incializarla.
     * @return {@code true} si no hubo ningún error, {@code false} si es que hubo algún error (controlado) al momento de leer la base de datos desde el sistema de archivos.
     */
    private static boolean inicializarBaseDatosGeneracionAlumnos( BaseDatos bd ) {
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
//                System.out.println( fileContent ); // <--- Impresión de los nombres según se van leyendo de archivos
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
            String apellido;
            String fileContent = br.readLine();
            while( fileContent != null )
            {
                StringTokenizer tokenizador = new StringTokenizer( fileContent, ",");
                while( tokenizador.hasMoreTokens() )
                {
                    apellido = tokenizador.nextToken();
//                    System.out.println( apellido ); // <--- Impresión de los apellidos según se leen de archivos
                    bd.addApellido( apellido );
                }
                fileContent = br.readLine();
            }
        } catch ( IOException e ) {
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
//                System.out.println(fileContent); // <--- Impresión de las direcciones según se leen de archivos
                fileContent = br.readLine();
            }
        } catch ( IOException e ) {
            System.out.println("Ha ocurrido un error al leer las direcciones físicas desde la ruta original.");
            throw new IOException( e );
        }
    }
}
