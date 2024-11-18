package modelo.AppClasses;

/**
 * Clase que contiene las credenciales de acceso al sistema de un usuario autorizado.
 * @author Oscar Rojas Cabrera 
 */
public class Usuario {
    /**
     * Nombre completo de la persona que accede al sistema (Usuario).
     */
    private String nombreUsuario;
    
    /**
     * Usuario / clave de acceso que utiliza el Usuario para identificarse al momento de acceder al sistema.
     */
    private String clave;
    
    /**
     * Contraseña que utiliza el Usuario para ingresar al sistema.
     */
    private String password;

    /**
     * Método que devuelve el nombre del Usuario.
     * @return Una cadena con el nombre del Usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método que establece el nombre del Usuario.
     * @param nombreUsuario Una cadena con el nombre del Usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método que devuelve la clave del Usuario.
     * @return Una cadena con la clave del Usuario.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método que establece la clave del Usuario.
     * @param clave Una cadena con la clave del Usuario.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método que devuelve la contraseña del Usuario.
     * @return Una cadena con la contraseña del Usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método que establece la contraseña del Usuario.
     * @param password Una cadena con la contraseña del Usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Método que permite la impresión en pantalla de manera amigable para el usuario toda la información pertinente sobre un Usuario en específico.
     */
    public void imprimirUsuario() {
        System.out.println("\nLos datos del usuario son los siguientes:"
                + "\n\tNombre:\t" + this.getNombreUsuario()
                + "\n\tUsuario:\t" + this.getClave()
                + "\n\tContraseña:\t" + this.getPassword());
    }
}
