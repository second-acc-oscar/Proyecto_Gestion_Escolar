package vista;
import controlador.Sistema;
import java.util.Scanner;
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
    public static void iniciar(){
        /**
         * Fragmento de codigo encargado de solicitar al usuario la accsion deseada haciendo uso de un while y un switch
         */
        System.out.println("Hola Academico\n ¿Que cambio quiere hacer?");
        System.out.println("1)Consultar estudiantes \n2)Agregar algún estudiantes \n3)Modificar algun estudiantes \n4)Eliminar algun estudiantes \n5)Visualizar FDU \6)Convertitr alumnoen FDU \n7)Salir");
        try {
            Scanner lectura = new Scanner(System.in);
            int op = lectura.nextInt();
            imprimirMenu(op);
        }catch(java.util.InputMismatchException e){
            System.out.println("Se ingresó una opción invalida\n");
            iniciar();
        }
        
    }
    
    /**
     * Metodo encargado de ejecutar la opción seleccionada por el usuario
     */
    private static void imprimirMenu(int op){
        Scanner lectura = new Scanner(System.in);
        while(op != 7){    
            switch(op){
                case 1 -> {
                    consultarEstudiantes();
                }
                
                case 2 -> {
                    System.out.println("Ingresa el nombre del estudiante a agregar: ");
                    String nombre = lectura.next();
                    System.out.println("Ingresa la apellido del estudiante a agregar: ");
                    String apellido = lectura.next();
                    System.out.println("Ingresa la domicilio del estudiante a agregar: ");
                    String domicilio = lectura.next();
                    System.out.println("Ingresa la correo del estudiante a agregar: ");
                    String correo = lectura.next();
                    System.out.println("Ingresa la edad del estudiante a agregar: ");
                    int edad = lectura.nextInt();
                    agregarEstudiantes(nombre, apellido, domicilio, correo, edad);
                }

                case 3 -> {
                    boolean tmpNC;
                    System.out.println("Ingresa el numero de cuenta del estudiante a modificar: ");
                    int numeroCuenta = lectura.nextInt();
                    do{
                        tmpNC = verificarNumeroCuenta(numeroCuenta);
                        if(tmpNC == false)
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            numeroCuenta = lectura.nextInt();
                    }while(tmpNC != true);
                    modificarEstudiante(numeroCuenta);
                }

                case 4 -> { 
                    boolean tmpNC;
                    System.out.println("Ingresa el numero de cuenta del estudiante a modificar: ");
                    int numeroCuenta = lectura.nextInt();
                    do{
                        tmpNC = verificarNumeroCuenta(numeroCuenta);
                        if(tmpNC == false)
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            numeroCuenta = lectura.nextInt();
                    }while(tmpNC != true);
                    eliminarEstudiante(numeroCuenta);
                }
                
                case 5 -> {
                    consultarFDU();
                }
                
                case 6 -> {
                    boolean tmpNC;
                    System.out.println("Ingresa el numero de cuenta del estudiante al que quiere volver un FDU: ");
                    String clave = lectura.next();
                    do{
                        tmpNC = verificarNumeroCuenta(clave);
                        if(tmpNC == false)
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            clave = lectura.next();
                    }while(tmpNC != true);
                    volverEnFDU(clave);
                }
                
                case 7 -> {
                    op = 7;
                    System.out.println("Saliendo del sistema");
                }
                
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        }
    }
    
    /**
     * Metodo encargado de solicitar el sistema que imprima la lista de los Estudiantes registrados
     */
    private static void consultarEstudiantes() {
        Sistema.imprimirEstudiantes();
    }
    
    /**
     * Metodo encargado de solicitar el sistema que imprima la lista de los FDU registrados
     */
    private static void consultarFDU() {
        Sistema.imprimirFDU();
    }
    
    /**
     * Metodo encargado de informar si el numero de cuenta ingresado existe
     * @param clave
     * @return 
     */
    private static boolean verificarNumeroCuenta(int numeroCuenta){
        return Sistema.verificarNumeroCuenta(clave);
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un estudiante 
     */
    private static void agregarEstudiantes(String nombre, String clave, String contrasena, String correo, int edad){
        Sistema.agregarEstudianteS(nombre, clave, contrasena, correo, edad);
        System.out.println("Se agrego el estudiante solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que modifique el estudiante solicitado
     */
    private static void modificarEstudiante(int numeroCuenta){
        Sistema.modificarEstudianteS(numeroCuenta);
        System.out.println("Se elimino el estudiante solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el estudiante solicitado
     */ 
    private static void eliminarEstudiante(int numeroCuenta){
        Sistema.eliminarEstudianteS(numeroCuenta);
        System.out.println("Se elimino el estudiante solicitado");
    }
    
}