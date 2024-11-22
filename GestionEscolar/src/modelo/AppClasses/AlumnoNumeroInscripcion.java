package modelo.AppClasses;

import controlador.CalculoNoInscripcion;

/**
 * Clase que representa a un <b>par</b> que agrupa a un alumno (identificable por su número de cuenta) y el indicador escolar de éste.
 * Facilita la lógica del cálculo del número de inscripción.
 * @author Saúl Ojeda
 */
public class AlumnoNumeroInscripcion {
    /**
     * El número de cuenta del Alumno que se encuentra en el par.
     */
    private int numeroCuenta;
    
    /**
     * El indicador escolar del Alumno que se encuentra en el par.
     */
    private double indicadorEscolar;

    /**
     * Método que crea una nueva instancia vacía de AlumnoNumeroInscripcion.
     */
    public AlumnoNumeroInscripcion() {
    }

    /**
     * Método que crea una instancia llena de AlumnoNumeroInscripcion.
     * @param numeroCuenta El indicador escolar del Alumno que se encuentra en el par.
     * @param indicadorEscolar Método que crea una nueva instancia vacía de AlumnoNumeroInscripcion.
     */
    public AlumnoNumeroInscripcion( int numeroCuenta, double indicadorEscolar ) {
        this.numeroCuenta = numeroCuenta;
        this.indicadorEscolar = indicadorEscolar;
    }

    /**
     * Método que devuelve el número de cuenta del Alumno asociado al par.
     * @return El número de cuenta asociado al par.
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método que establece el número de cuenta asociado al par.
     * @param numeroCuenta El número de cuenta asociado al par.
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método que devuelve el indicador escolar asociado al Alumno del par.
     * @return El indicador escolar asociado al Alumno del par.
     */
    public double getIndicadorEscolar() {
        return indicadorEscolar;
    }

    /**
     * Método que establece el indicador escolar asociado al Alumno del par.
     * @param indicadorEscolar El indicador escolar asociado al Alumno del par.
     */
    public void setIndicadorEscolar(double indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }
}
