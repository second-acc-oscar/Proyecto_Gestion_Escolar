package modelo.AppClasses;

import java.time.LocalDate;
import java.time.LocalTime;
import controlador.Sistema;

/**
 * Clase que representa una snapshot del inicio de sesión al sistema por parte de un Usuario conocido.
 * @author Oscar Rojas
 */
public class RegistroLogin {
    /**
     * La fecha en que se realizó el inicio de sesión en el sistema, encapsulado en un objeto de tipo LocalDate.
     */
    LocalDate fecha;
    
    /**
     * La hora en que se realizó el inicio de sesión en el sistema, encapsulado en un objeto de tipo LocalTime.
     */
    LocalTime hora;
    
    /**
     * El identificador del usuario que inición sesión en el sistema.
     */
    String claveUsuario;
    
    /**
     * Crea una nueva instancia de RegistroLogin vacía.
     */
    public RegistroLogin() {
    }

    /**
     * Crea una nueva instancia de RegistroLogin llena.
     * @param fecha La fecha en que se realizó el inicio de sesión en el sistema, encapsulado en un objeto de tipo LocalDate.
     * @param hora La hora en que se realizó el inicio de sesión en el sistema, encapsulado en un objeto de tipo LocalTime.
     * @param claveUsuario El identificador del usuario que inición sesión en el sistema.
     */
    public RegistroLogin(String claveUsuario, LocalDate fecha, LocalTime hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.claveUsuario = claveUsuario;
    }
    
    /**
     * Método que permite la impresión en pantalla de manera amigable para el usuario toda la información pertinente sobre un Alumno en específico.
     */
    public void imprimir() {
        System.out.println("\tUsuario:\t" + Sistema.getNombreAcademico(this.claveUsuario) + "\tAcceso:\t" + fecha + "\tHora:\t" + hora );
    }
    
    /**
     * Método que convierte el estado de los atributos del RegistroLogin en una cadena con formato CSV.
     * @return El estado de los atributos del objeto en cadena, separados cada uno por comas (formato CSV).
     */
    public String toCSV() {
        String coma = ",";
        return claveUsuario + coma + fecha + coma + hora;
    }
}
