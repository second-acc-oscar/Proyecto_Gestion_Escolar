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
        System.out.println("1)Consultar estudiantes \n2)Agregar algún estudiantes \n3)Modificar algun estudiantes \n4)Eliminar algun estudiantes \n5)Salir");
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
        while(op != 5){    
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
                    String clave = lectura.next();
                    do{
                        tmpNC = verificarClaveRepetida(clave);
                        if(tmpNC == false)
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            clave = lectura.next();
                    }while(tmpNC != true);
                    modificarEstudiante(clave);
                }

                case 4 -> { 
                    boolean tmpNC;
                    System.out.println("Ingresa el numero de cuenta del estudiante a modificar: ");
                    String clave = lectura.next();
                    do{
                        tmpNC = verificarClaveRepetida(clave);
                        if(tmpNC == false)
                            System.out.println("Ese numero de cuenta no existe, use uno diferente");
                        else
                            clave = lectura.next();
                    }while(tmpNC != true);
                    eliminarEstudiante(clave);
                }
                
                case 5 -> {
                    op = 5;
                    System.out.println("Saliendo del sistema");
                }
                
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        }
    }
    
    /**
     * Metodo encargado de solicitar el sistema que imprima la lista de los academicos registrados
     */
    private static void consultarEstudiantes() {
        Sistema.imprimirEstudiantes();
    }
    
    /**
     * Metodo encargado de informar si la clave ingresada existe
     * @param clave
     * @return 
     */
    private static boolean verificarnNumeroDeCuentaRepetida(String clave){
        return Sistema.verificarNumeroDeCuentaRepetido(clave);
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un estudiante 
     */
    private static void agregarEstudiantes(String nombre, String clave, String contrasena, String correo, int edad){
        Sistema.agregarEstudianteS(nombre, clave, contrasena);
        System.out.println("Se agrego el estudiante solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que modifique el estudiante solicitado
     */
    private static void modificarEstudiante(String clave){
        Sistema.modificarEstudianteS(clave);
        System.out.println("Se elimino el estudiante solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el estudiante solicitado
     */ 
    private static void eliminarEstudiante(String clave){
        Sistema.eliminarEstudianteS(clave);
        System.out.println("Se elimino el estudiante solicitado");
    }
    
}