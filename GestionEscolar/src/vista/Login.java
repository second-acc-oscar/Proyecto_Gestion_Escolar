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
            input.nextLine();

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
        while( ! Admin.getContra().equals(credencial) && ! credencial.equals("1") )
        {
            System.out.println("Contraseña incorrecta, ingresa la contraseña correcto, o \"1\" para salir.");
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
        Sistema.inicializarUsuarios();
        
        System.out.println("Por favor, ingrese su clave de usuario: ");
        Scanner lecturaCl = new Scanner(System.in);
        String clave = lecturaCl.nextLine();
        while( ! Sistema.existeUsuario(clave) ){
            System.out.println("Esa clave no existe, use una diferente.");
            clave = lecturaCl.nextLine();
        }
        
        System.out.println("Ingrese su contraseña: ");
        Scanner lecturaCon = new Scanner(System.in);
        String contrasena = lecturaCon.nextLine();
        while( ! Sistema.coincideContrasena(clave, contrasena) ){
            System.out.println("Contraseña inválida, ingrese nuevamente.");
            contrasena = lecturaCl.nextLine();
        }

        Sistema.inicializarBaseDeDatos(false);
        PersonalAcademico.iniciar( clave );
        Sistema.escribirArchivos(false);
    }
}

