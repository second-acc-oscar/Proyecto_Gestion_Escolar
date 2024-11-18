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
                    boolean tmpCl;
                    System.out.println("Ingresa el nombre del estudiante a agregar: ");
                    String nombre = lectura.next();
                    System.out.println("Ingresa la clave del estudiante a agregar: ");
                    String clave = lectura.next();
                    do{
                        tmpCl = verificarClaveRepetida(clave);
                        if(tmpCl == true)
                            System.out.println("Esa clave ya existe, use una diferente");
                        else
                            clave = lectura.next();
                    }while(tmpCl != false);
                    System.out.println("Ingresa la contraseña del estudiante a agregar: ");
                    String contrasena = lectura.next();
                    agregarAcademicos(nombre, clave, contrasena);
                }

                case 3 -> {
                    boolean tmpCl;
                    System.out.println("Ingresa la clave del estudiante a modificar: ");
                    String clave = lectura.next();
                    do{
                        tmpCl = verificarClaveRepetida(clave);
                        if(tmpCl == false)
                            System.out.println("Esa clave no existe, use una diferente");
                        else
                            clave = lectura.next();
                    }while(tmpCl != true);
                    modificarAcademicos(clave);
                }

                case 4 -> { 
                    boolean tmpCl;
                    System.out.println("Ingresa la clave del academico a eliminar: ");
                    String clave = lectura.next();
                    do{
                        tmpCl = verificarClaveRepetida(clave);
                        if(tmpCl == false)
                            System.out.println("Esa clave no existe, use una diferente");
                        else
                            clave = lectura.next();
                    }while(tmpCl != true);
                    eliminarAcademicos(clave);
                }
                
                case 5 -> {
                    op = 5;
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
    private static boolean verificarClaveRepetida(String clave){
        return Sistema.verificarClaveRepetida(clave);
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un estudiante 
     */
    private static void agregarAcademicos(String nombre, String clave, String contrasena){
        Sistema.agregarAcademicoS(nombre, clave, contrasena);
        System.out.println("Se agrego el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que modifique el estudiante solicitado
     */
    private static void modificarAcademicos(String clave){
        Sistema.modificarAcademicoS(clave);
        System.out.println("Se elimino el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el estudiante solicitado
     */ 
    private static void eliminarAcademicos(String clave){
        Sistema.eliminarAcademicoS(clave);
        System.out.println("Se elimino el academico solicitado");
    }
    
}