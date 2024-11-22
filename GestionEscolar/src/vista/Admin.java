package vista;
import controlador.Sistema;
import java.util.Scanner;
import modelo.AppClasses.Usuario;
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
    private static final String CONTRA_ADMIN = "LUL1234";
    private static final String USUARIO_ADMIN = "Admin";
    
    /**
     * Método que devuelve el usuario reconocido como administrador para iniciar sesión.
     * @return El usuario del administrador.
     */
    public static String getUsuario() {
        return USUARIO_ADMIN;
    }
    
    /**
     * Método que devuelve la contraseña reconocida para el administrador al iniciar sesión.
     * @return La contraseña del administrador.
     */
    public static String getContra() {
        return CONTRA_ADMIN;
    }
    
    /**
     * Metodo encargado de iniciar las acciones de la clase basado en la opción solicitada por el usuario
     */
    public static void iniciar(){
        Scanner lectura = new Scanner(System.in);
        int op;
        
        do{
            System.out.println("Hola, Administrador"
                    + "\n¿Que cambio quiere hacer?"
                    + "\n\t1)Consultar academicos "
                    + "\n\t2)Agregar algún academico "
                    + "\n\t3)Modificar algun academico "
                    + "\n\t4)Eliminar algun academico "
                    + "\n\t5)Verificar los accesos "
                    + "\n\t6)Salir");
            
            op = lectura.nextInt(); 
            
            switch(op){
                case 1 -> Sistema.imprimirAcademicos();

                case 2 -> {
                    lectura.nextLine();
                    System.out.println("Ingresa el nombre del academico a agregar: ");
                    String nombre = lectura.nextLine();

                    System.out.println("Ingresa la clave del academico a agregar: ");
                    String clave = lectura.nextLine();

                    while( Sistema.existeUsuario(clave) ){
                        System.out.println("Esa clave ya existe, use una diferente");
                        clave = lectura.nextLine();
                    }
                    System.out.println("Ingresa la contraseña del academico a agregar: ");
                    String contrasena = lectura.nextLine();
                    agregarAcademicos(nombre, clave, contrasena);
                }

                case 3 -> {
                    System.out.println("Ingresa la clave del academico a modificar: ");
                    String clave = lectura.nextLine();
                    while( ! Sistema.existeUsuario(clave) ){
                        System.out.println("Esa clave no existe, use una diferente");
                        clave = lectura.nextLine();
                    }
                    modificarAcademicos(clave);
                }

                case 4 -> { 
                    System.out.println("Ingresa la clave del academico a eliminar: ");
                    String clave = lectura.nextLine();
                    while( ! Sistema.existeUsuario(clave) ){
                        System.out.println("Esa clave no existe, use una diferente");
                        clave = lectura.next();
                    }
                    eliminarAcademicos(clave);
                }

                case 5 -> verificarAcesos();

                case 6 -> System.out.println("Saliendo del sistema");

                default -> {
                    System.out.println("La opción ingresada es invalida");
                    System.out.println("Ingrese una nueva opcion valida");
                }
            }
        }while(op != 6);
    }
    
    /**
     * Metodo encargado de solicitar el sistema que agregue un academico 
     * @param nombre
     * @param clave
     * @param contrasena 
     */
    private static void agregarAcademicos(String nombre, String clave, String contrasena){
        Usuario usuario = new Usuario(nombre, clave, contrasena);
        Sistema.agregarAcademico(usuario);
        System.out.println("Se agrego el academico solicitado");
    }
    
    /**
     * Metodo encargado de modificar los datos correspondientes a un academico solicitado, siendso que funciona para cualquiera de los campos existentes
     * @param clave
     */
    private static void modificarAcademicos(String clave){
        int op;
        Usuario usuario = Sistema.getUsuario( clave );
        
        do{   
            System.out.println("Ingresa el numero correspondiente al dato que quieres modificar"
                    + "\n1)Nombre"
                    + "\n2)Clave"
                    + "\n3)Contraseña");
            Scanner lectura = new Scanner(System.in);
            op = lectura.nextInt();        
 
            switch (op) {
                case 1 -> {
                    lectura.nextLine();
                    System.out.println("Ingrese el nuevo nombre");
                    String nombre = lectura.nextLine();
                    usuario.setNombreUsuario(nombre);
                }

                case 2 -> {
                    lectura.nextLine();
                    System.out.println("Ingrese la nueva clave");
                    String nclave = lectura.nextLine();
                    usuario.setClave(nclave);
                }

                case 3 -> {
                    lectura.nextLine();
                    System.out.println("Ingrese la nueva contraseña");
                    String contrasena = lectura.nextLine();
                    usuario.setPassword(contrasena);
                }

                default -> {
                    System.out.println("La opción ingresada es invalida");
                    System.out.println("Ingrese una nueva opcion valida");
                }
            }
        }while(op != 1 && op != 2  && op != 3);
        
        
        System.out.println("Se modificó el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que elimine el academico solicitado
     */ 
    private static void eliminarAcademicos(String clave){
        Sistema.eliminarAcademico(clave);
        System.out.println("Se elimino el academico solicitado");
    }
    
    /**
     * Metodo encargado de solicitar el sistema que verifique los academicos que ingresaron al programa
     */ 
    private static void verificarAcesos(){
        Sistema.verificarAccesos();
    }
}