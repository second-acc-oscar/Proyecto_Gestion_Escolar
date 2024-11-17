package vista;
import controlador.Sistema;
import java.util.Scanner;
/**
 * Clase que establece las acciones quie pueden ser realizadas por un administrador
 * 
 * En sus capacidades se encuentra que puede realizar las siguientes acciones:
 * <ul>
 *   <li>Agregar academicos.</li>
 *   <li>Modoficar academicos.</li>
 *   <li>Eliminar academicos.</li>
 *   <li>Verificar accesos. </li>
 * </ul>
 * 
 * @author Saúl Ojeda
 */
public class Admin {
    /**
     * Metodo encargado de iniciar las acciones de la clase basado en la opción solicitada por el usuario
     */
    public static void iniciar(){
        /**
         * Fragmento de codigo encargado de solicitar al usuario la accsion deseada haciendo uso de un while y un switch
         */
        System.out.println("Hola Administrador\n ¿Que cambio quiere hacer?");
        System.out.println("1)Consultar academicos \n2)Agregar algún academico \n3)Modificar algun academico \n4)Eliminar algun academico \n5)Verificar los accesos \n6)Salir");
        Scanner lectura = new Scanner(System.in);
        int op = lectura.nextInt();
        while(op != 5){    
            switch(op){
                case 1 -> {
                    consultarAcademicos();
                }
                
                case 2 -> {
                    System.out.println("Ingresa el nombre del academico a modificar: ");
                    String academico = lectura.next();
                    agregarAcademicos(academico);
                }

                case 3 -> {
                    System.out.println("Ingresa el nombre del academico a modificar: ");
                    String academico = lectura.next();
                    modificarAcademicos(academico);
                }

                case 4 -> { 
                    System.out.println("Ingresa el nombre del academico a eliminar: ");
                    String academico = lectura.next();
                    eliminarAcademicos(academico);
                }

                case 5 -> {
                    verificarAcesos();
                }
                
                case 6 -> {
                    op = 5;
                }
                
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        }
    }

    /**
     * Variable encargada de interactuar con la clase sistema
     */
    Sistema sistema = Sistema.getInstance();
    
    /**
     * Metodo encargado de solicitar el sistema que imprima la lista de los academicos registrados
     */
    private static void consultarAcademicos() {
        sistema.imprimirAcademicoS();
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un academico 
     */
    private static void agregarAcademicos(String academico){
        sistema.agregarAcademicoS(academico);
        System.out.println("Se elimino el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que modifique el academico solicitado
     */
    private static void modificarAcademicos(String academico){
        sistema.modificarAcademicoS(academico);
        System.out.println("Se elimino el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el academico solicitado
     */ 
    private static void eliminarAcademicos(String academico){
        sistema.eliminarAcademicoS(academico);
        System.out.println("Se elimino el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que verifique los academicos que ingresaron al programa
     */ 
    private static void verificarAcesos(){
        sistema.verificarAccesosS();
        System.out.println("Se elimino el academico solicitado");
    }
}
