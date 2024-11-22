package vista;

import controlador.Sistema;
import java.util.Scanner;

/**
 * Clase que se encarga de dar acceso a el programa
 * @author Saúl Ojeda
 */
public class Login {
    /**
     * Metodo encargado de iniciar las acciones correspondientes al login
     */
    public static void iniciar(){
        Scanner input = new Scanner(System.in);
        int option;
        
        do{
            System.out.println("Bienvenido, ¿como qué quieres iniciar sesión?"
                + "\n\t1. Admin."
                + "\n\t2. Usuario."
                + "\n\t3. Salir.\n");
            option = input.nextInt();

            switch( option ) {
                case 1 -> iniciarAdmin();
                case 2 -> iniciarUsuario();
                case 3 -> System.out.println("¡Hasta luego, vuelve pronto!");
                default -> System.out.println("Opción no válida.");
            }
        }while(option != 3);
    }
    
    /**
     * Método que valida las credenciales de acceso para un Usuario que intenta iniciar sesión como Administrador.
     */
    private static void iniciarAdmin() {
        Scanner input = new Scanner(System.in);
        String credencial;
        
        System.out.println("Por favor, ingresa el usuario de administrador:");
        credencial = input.next();
        while( ! Admin.getUsuario().equals(credencial) && ! credencial.equals("1") )
        {
            System.out.println("Usuario incorrecto, ingresa el usuario correcto, o \"1\" para salir.");
            credencial = input.next();
        }
        if( credencial.equals("1"))
        {
            System.out.println("Regresando...");
            return;
        }
        System.out.println("Por favor, ingresa la contraseña:");
        credencial = input.next();
        while( (! Admin.getUsuario().equals(credencial)) && (! credencial.equals("1")) )
        {
            System.out.println("Contraseña incorrecta, ingresa el usuario correcto, o \"1\" para salir.");
            credencial = input.next();
        }
        if( credencial.equals("1"))
        {
            System.out.println("Regresando...");;
            return;
        }
        Sistema.inicializarBaseDeDatos(true);
        Admin.iniciar();
        Sistema.escribirArchivos(true);
    }
        
    /**
     * Método que valida las credenciales de acceso para un Usuario que intenta iniciar sesión.
     */
    private static void iniciarUsuario() {
        System.out.println("Por favor, ingrese su clave de usuario: ");
        Scanner lecturaCl = new Scanner(System.in);
        String clave = lecturaCl.next();
        boolean tmpCl;
        do{
            tmpCl = verificarClaveExistente(clave);
            if(tmpCl == false){
                System.out.println("Esa clave no existe, use una diferente");
                clave = lecturaCl.next();
            }
        }while(tmpCl != true);
        
        System.out.println("Ingrese su contrasena: ");
        Scanner lecturaCon = new Scanner(System.in);
        String contrasena = lecturaCon.next();
        do{
            tmpCl = verificarContrasenaCoincide(contrasena, clave);
            System.out.println(tmpCl);
            if(tmpCl == false){
                System.out.println("Esa clave no existe, use una diferente");
                contrasena = lecturaCl.next();
            }
        }while(tmpCl != true);
/*        System.out.println("Ingrese el valor correspondiente a la forma en la que quiuere ingresar \n1)Academico \n2)Administrador");
        Scanner lectura = new Scanner(System.in);
        int acc = lectura.nextInt();
        do{
            switch (acc) {
                case 1 -> PersonalAcademico.iniciar();
                case 2 -> Admin.iniciar();
                default -> {
                    System.out.println("El valor ingresado no es valido");
                    System.out.println("Ingrese un valor valido");
                    acc = lectura.nextInt();
                }
            }¨
        }while(acc != 1 || acc != 2);
*/
        Sistema.inicializarBaseDeDatos(false);
        PersonalAcademico.iniciar( Sistema.getNombreAcademico(clave) );
        Sistema.escribirArchivos(false);
    }
    
    /**
     * Metodo que verifica la existencia de la clave ingresada
     * @param clave
     * @return 
     */
    private static boolean verificarClaveExistente(String clave) {
        return Sistema.existeUsuario(clave);
    }

    /**
     * Metodo encargado de verificar si la contraseña coincide con la clave previamente ingresada
     * @param contrasena
     * @param clave
     * @return 
     */
    private static boolean verificarContrasenaCoincide(String contrasena, String clave) {
        return Sistema.coincideContrasena(clave, contrasena);
    }
}

