package vista;

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
        System.out.println("Ingrese su clave de usuario: ");
        Scanner lecturaCl = new Scanner(System.in);
        String clave = lecturaCl.next();
        boolean tmpCl;
        do{
            tmpCl = verificarClaveExistente(clave);
            if(tmpCl == false)
                System.out.println("Esa clave no existe, use una diferente");
            else
                clave = lecturaCl.next();
        }while(tmpCl != true);
        
        System.out.println("Ingrese su contrasena: ");
        Scanner lecturaCon = new Scanner(System.in);
        String contrasena = lecturaCon.next();
        do{
            tmpCl = verificarContrasenaCoincide(contrasena, clave);
            if(tmpCl == false)
                System.out.println("Esa clave no existe, use una diferente");
            else
                contrasena = lecturaCl.next();
        }while(tmpCl != true);
    }
    
    /**
     * Metodo que verifica la existencia de la clave ingresada
     * @param clave
     * @return 
     */
    private static boolean verificarClaveExistente(String clave) {
        return Sistema.verificarClaveExistenteS();
    }

    /**
     * Metodo encargado de verificar si la contraseña coincide con la clave previamente ingresada
     * @param contrasena
     * @param clave
     * @return 
     */
    private static boolean verificarContrasenaCoincide(String contrasena, String clave) {
        return Sistema.verificarContrasenaCoincideS();
    }
}
