package modelo.AppClasses;

import controlador.MergeSort;

/**
 *
 * @author Saúl Ojeda
 */
public class AlumnoNumeroInscripcion {
    private int numeroCuenta;
    private float indicadorEscolar;
    private int numeroInscripcion;

    public AlumnoNumeroInscripcion() {
    }

    public AlumnoNumeroInscripcion(int numeroCuenta, float indicadorEscolar, int numeroInscripcion) {
        this.numeroCuenta = numeroCuenta;
        this.indicadorEscolar = indicadorEscolar;
        this.numeroInscripcion = numeroInscripcion;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getIndicadorEscolar() {
        return indicadorEscolar;
    }

    public void setIndicadorEscolar(float indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
    
    public void Merge(float indicadorEscolar){
        MergeSort(indicadorEscolar);
    }
}
