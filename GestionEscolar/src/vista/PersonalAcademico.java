package vista;
import java.util.Scanner;
import controlador.Sistema;
import controlador.CalculoNoInscripcion;
import java.util.ArrayList;
import modelo.AppClasses.Alumno;
import modelo.AppClasses.AlumnoNumeroInscripcion;
import modelo.AppClasses.Usuario;
/**
 * Clase que establece las acciones quie pueden ser realizadas por un administrador
 * 
 * En sus capacidades se encuentra que puede realizar las siguientes acciones:
 * <ul>
 *   <li>Agregar estudiantes.</li>
 *   <li>Modoficar estudiantes.</li>
 *   <li>Eliminar estudiantes.</li>
 *   <li>Verificar estudiantes. </li>
 * </ul>
 * 
 * @author Saúl Ojeda
 */
public class PersonalAcademico {
    /**
     * Metodo encargado de iniciar las acciones de la clase basado en la opción solicitada por el usuario
     */
    public static void iniciar( String claveUsuario ){
        Sistema.registrarNuevoLogin( claveUsuario );
        
        Scanner lectura = new Scanner(System.in);
        int op;
        try {
            do {
                System.out.println("Hola " + Sistema.getNombreAcademico(claveUsuario)
                        + "\n¿Qué quieres hacer?"
                        + "\n\t1)Consultar estudiantes "
                        + "\n\t2)Agregar algún estudiantes "
                        + "\n\t3)Modificar algun estudiantes "
                        + "\n\t4)Eliminar algun estudiantes "
                        + "\n\t5)Calcular número de inscripción"
                        + "\n\t6)Salir");
                op = lectura.nextInt();

                switch(op){
                    case 1 -> {
                        System.out.println("Ingresa el número de cuenta del estudiante que quieres consultar, o la palabra \"todos\" para ver todos.");
                        String option = lectura.next();
                        if( option.equals("todos") )
                            consultarEstudiantes();
                        else
                            if( Sistema.existeAlumno( Integer.parseInt(option) ) )
                                Sistema.getAlumno( Integer.parseInt(option) ).imprimirAlumno();
                            else
                                System.out.println("Alumno no encontrado.");
                    }

                    case 2 -> {
                        System.out.println("¿De qué forma quieres añadir alumnos al sistema?"
                                + "\n\t1) De manera aleatoria."
                                + "\n\t2) De manera manual.");
                        int option = lectura.nextInt();

                        switch( option ){
                            case 1 -> {
                                System.out.println("¿Cuántos alumnos aleatorios quieres agregar?");
                                option = lectura.nextInt();

                                if( option < 1 || option > 1000 )
                                    System.out.println("Opción no válida.");
                                else {
                                    System.out.println("Se han añadido los siguientes Alumnos:");

                                    for( int i = 0; i < option; i++ ) {
                                        Alumno nuevoAlumno = Alumno.generarAlumnoAleatorio();
                                        nuevoAlumno.imprimirAlumno();
                                    }
                                }
                            }
                            case 2 -> {
                                lectura.nextLine();
                                System.out.println("Ingresa el nombre del estudiante a agregar: ");
                                String nombre = lectura.nextLine();
                                System.out.println("Ingresa la apellido paterno del estudiante a agregar: ");
                                String apellidoPaterno = lectura.nextLine();
                                System.out.println("Ingresa la apellido materno del estudiante a agregar: ");
                                String apellidoMaterno = lectura.nextLine();
                                System.out.println("Ingresa la domicilio del estudiante a agregar: ");
                                String domicilio = lectura.nextLine();
                                System.out.println("Ingresa la correo del estudiante a agregar: ");
                                String correo = lectura.nextLine();
                                System.out.println("Ingresa la edad del estudiante a agregar: ");
                                int edad = lectura.nextInt();
                                lectura.nextLine();
                                agregarEstudiantes(nombre, apellidoPaterno, apellidoMaterno, domicilio, correo, edad);   
                            }
                            default -> System.out.println("Opción inválida.");
                        }
                    }

                    case 3 -> {
                        boolean tmpNC;
                        System.out.println("Ingresa el numero de cuenta del estudiante a modificar: ");
                        int numeroCuenta = lectura.nextInt();
                        if( Sistema.existeAlumno(numeroCuenta) )
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                        {
                            modificarEstudiante(numeroCuenta);
                        }
                    }

                    case 4 -> { 
                        boolean tmpNC;
                        System.out.println("Ingresa el numero de cuenta del estudiante a modificar: ");
                        int numeroCuenta = lectura.nextInt();
                        if( ! Sistema.existeAlumno(numeroCuenta) )
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            eliminarEstudiante(numeroCuenta);
                    }

                    case 5 -> calcularNoInscripcion();

                    case 6 -> System.out.println("Saliendo del sistema");

                    default -> System.out.println("Ingrese una opcion valida");
                }
            }while( op != 6 );
        }catch(java.util.InputMismatchException e){
            System.out.println("Se ingresó una opción invalida\n");
            iniciar( claveUsuario );
        }
    }
    
    /**
     * Metodo encargado de solicitar el sistema que imprima la lista de los Estudiantes registrados
     */
    private static void consultarEstudiantes() {
        Sistema.imprimirAlumnos();
    }
    
    /**
     * Metodo encargado de informar si el numero de cuenta ingresado existe
     * @param clave
     * @return 
     */
    private static boolean verificarNumeroCuenta(int numeroCuenta){
        return Sistema.existeAlumno(numeroCuenta);
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un estudiante 
     */
    private static void agregarEstudiantes(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String correo, int edad ){
        Alumno.generarAlumnoNoAleatorio(nombre, apellidoPaterno, apellidoMaterno, domicilio, correo, edad);
        System.out.println("Se agrego el estudiante solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que modifique el estudiante solicitado
     */
    private static void modificarEstudiante(int numeroCuenta){
        Scanner input = new Scanner(System.in);
        int option;
        String field;
        
        System.out.println("¿Qué es lo que quieres modificar del estudiante?"
                + "\n\t1) Nombre"
                + "\n\t2) Apellido Paterno"
                + "\n\t3) Apellido Materno"
                + "\n\t4) Domicilio"
                + "\n\t5) Correo"
                + "\n\t6) Edad");
        option = input.nextInt();
        
        if( ! ( option > 0 && option < 7 )) {
            System.out.println("Opción inválida.");
            return;
        }
        
        System.out.println("Por favor, ingresa el nuevo valor:");
        field = input.next();
        
        Alumno alumno = Sistema.getAlumno(numeroCuenta);
        
        switch(option) {
            case 1 -> alumno.setNombre(field);
            case 2 -> alumno.setApellidoPaterno(field);
            case 3 -> alumno.setApellidoMaterno(field);
            case 4 -> alumno.setDomicilio(field);
            case 5 -> alumno.setCorreo(field);
            case 6 -> alumno.setEdad( Integer.parseInt(field) );
        }
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el estudiante solicitado
     */ 
    private static void eliminarEstudiante(int numeroCuenta){
        Sistema.eliminarEstudiante(numeroCuenta);
        System.out.println("Se elimino el estudiante solicitado");
    }
    
    /**
     * Método que lleva a cabo el menú de interaccón con el usuario para las opciones relacionadas al cálculo del número de inscripción.
     */
    private static void calcularNoInscripcion() {
        ArrayList<AlumnoNumeroInscripcion> lista = Sistema.getListaAlumnoNumeroInscripcion();
        CalculoNoInscripcion.calcular( lista );
        Scanner input = new Scanner(System.in);
        int option;
        
        do{
            System.out.println("¿Qué es lo que quieres hacer?"
                    + "\n\t1) Ver todos los alumnos. (Con el número actualizado)."
                    + "\n\t2) Buscar el alumno que tenga cierto número de inscripción."
                    + "\n\t3) Salir.");
            option = input.nextInt();
            
            switch(option) {
                case 1 -> Sistema.imprimirAlumnos();
                case 2 -> {
                    System.out.println("\n\t¿El alumno con qué número de cuenta quieres buscar?");
                    int numero = input.nextInt();
                    if( numero > Sistema.getNumAlumnos() || numero < 1 )
                        System.out.println("No hay tantos alumnos en el sistema;");
                    else
                        Sistema.getAlumno( lista.get(numero-1).getNumeroCuenta() ).imprimirAlumno();
                }
            }
        }while(option != 3);
        
    }
}