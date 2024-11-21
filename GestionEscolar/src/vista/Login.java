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
        System.out.println("Ingrese su clave de usuario: ");
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
        System.out.println("Ingrese el valor correspondiente a la forma en la que quiuere ingresar \n1)Academico \n2)Administrador");
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
            }
        }while(acc != 1 || acc != 2);
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

