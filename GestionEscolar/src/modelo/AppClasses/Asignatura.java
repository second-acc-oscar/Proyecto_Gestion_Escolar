package modelo.AppClasses;

/**
 * Clase que una de las asignaturas en el plan de estudios de la carrera de Ing. en Computación de la Facultad de Ingeniería.
 * @author Oscar Rojas
 */
public class Asignatura {
    /**
     * El nombre completo de la Asignatura.
     */
    private String nombre;
    
    /**
     * La clave de cuatro dígitos de la asignatura en formato de cadena. El nombre de los archivos se realiza conforme su clave.
     */
    private String clave;
    
    /**
     * Avance currícular en forma de créditos con los que cuenta cada asignatura por individual.
     */
    private int creditos;
    
    /**
     * Horas totales acumuladas en el semestre de las que se compone la asignatura para considerarse como cursada.
     */
    private int horasTotales;
    
    /**
     * Número del semestre regular en la que se debe de cursar la asignatura según el plan de estudios original de la carrera.
     */
    private int semestre;
    
    /**
     * Nombre de la asignatura que está seriada de manera antecedente a la Asignatura, deben cursarse en ese estricto orden por razones de continuidad de conocimientos.
     */
    private String seriacionAntecedente;
    
    /**
     * Nombre de la asignatura que está seriada de manera subsecuente a la Asignatura, deben cursarse en ese estricto orden por razones de continuidad de conocimientos.
     */
    private String seriacionSubsecuente;
    
    /**
     * Objetivos que se persigue el alumno consiga depués de que se haya cursado la Asignatura.
     */
    private String objetivo;

    /**
     * Crea una nueva instancia de Asignatura vacía.
     */
    public Asignatura() {
    }

    /**
     * Crea una nueva instancia de Asignatura llena.
     * @param nombre El nombre completo de la Asignatura.
     * @param clave La clave de cuatro dígitos de la asignatura en formato de cadena. El nombre de los archivos se realiza conforme su clave.
     * @param creditos Avance currícular en forma de créditos con los que cuenta cada asignatura por individual.
     * @param horasTotales Horas totales acumuladas en el semestre de las que se compone la asignatura para considerarse como cursada.
     * @param semestre Número del semestre regular en la que se debe de cursar la asignatura según el plan de estudios original de la carrera.
     * @param seriacionAntecedente Nombre de la asignatura que está seriada de manera antecedente a la Asignatura, deben cursarse en ese estricto orden por razones de continuidad de conocimientos.
     * @param seriacionSubsecuente Nombre de la asignatura que está seriada de manera subsecuente a la Asignatura, deben cursarse en ese estricto orden por razones de continuidad de conocimientos.
     * @param objetivo Objetivos que se persigue el alumno consiga depués de que se haya cursado la Asignatura.
     */
    public Asignatura(String nombre, String clave, int creditos, int horasTotales, int semestre, String seriacionAntecedente, String seriacionSubsecuente, String objetivo) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasTotales = horasTotales;
        this.semestre = semestre;
        this.seriacionAntecedente = seriacionAntecedente;
        this.seriacionSubsecuente = seriacionSubsecuente;
        this.objetivo = objetivo;
    }

    /**
     * Método que devuelve el nombre de la Asignatura.
     * @return Una cadena con el nombre de la Asignatura.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de la Asignatura.
     * @param nombre Una cadena con el nombre de la Asignatura.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve la clave de la Asignatura.
     * @return Una cadena con la clave de la Asignatura.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método que establece a clave de la Asignatura.
     * @param clave Una cadena con la clave de la Asignatura.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método que devuelve el número de créditos asignados a la Asignatura.
     * @return Un número entero, el número de créditos asignados a la Asignatura.
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Método que establece el número de créditos asignados a la Asignatura.
     * @param creditos Un número entero, el número de créditos asignados a la Asignatura.
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Método que devuelve las horas totales que se tienen que cursar al semestre para acreditar la Asignatura.
     * @return Un número entero, las horas totales que se tienen que cursar al semestre para acreditar la Asignatura.
     */
    public int getHorasTotales() {
        return horasTotales;
    }

    /**
     * Método que establece las horas totales que se tienen que cursar al semestre para acreditar la Asignatura.
     * @param horasTotales Un número entero, las horas totales que se tienen que cursar al semestre para acreditar la Asignatura.
     */
    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    /**
     * Método que devuelve el número en el cuál se debe cursar la Asignatura según el avance de créditos regular del plan de estudios.
     * @return Un número entero, el número en el cuál se debe cursar la Asignatura según el avance de créditos regular del plan de estudios.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Método que establece el número en el cuál se debe cursar la Asignatura según el avance de créditos regular del plan de estudios.
     * @param semestre Un número entero, el número en el cuál se debe cursar la Asignatura según el avance de créditos regular del plan de estudios.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Método que devuelve el nombre de la asignatura de seriación antecedente para la Asignatura.
     * @return Una cadena con el nombre de la asignatura de seriación antecedente para la Asignatura.
     */
    public String getSeriacionAntecedente() {
        return seriacionAntecedente;
    }

    /**
     * Método que establece el nombre de la asignatura de seriación antecedente para la Asignatura.
     * @param seriacionAntecedente Una cadena con el nombre de la asignatura de seriación antecedente para la Asignatura.
     */
    public void setSeriacionAntecedente(String seriacionAntecedente) {
        this.seriacionAntecedente = seriacionAntecedente;
    }

    /**
     * Método que devuelve el nombre de la asignatura de seriación subsecuente para la Asignatura.
     * @return Una cadena con el nombre de la asignatura de seriación subsecuente para la Asignatura.
     */
    public String getSeriacionSubsecuente() {
        return seriacionSubsecuente;
    }

    /**
     * Método que establece el nombre de la asignatura de seriación subsecuente para la Asignatura.
     * @param seriacionSubsecuente Una cadena con el nombre de la asignatura de seriación subsecuente para la Asignatura.
     */
    public void setSeriacionSubsecuente(String seriacionSubsecuente) {
        this.seriacionSubsecuente = seriacionSubsecuente;
    }

    /**
     * Método que devuelve el objetivo de la Asignatura que se espera el Alumno haya aprendido una vez curse la asignatura.
     * @return Una cadena con el objetivo de la Asignatura que se espera el Alumno haya aprendido una vez curse la asignatura.
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * Método que establece el objetivo de la Asignatura que se espera el Alumno haya aprendido una vez curse la asignatura.
     * @param objetivo Una cadena con el objetivo de la Asignatura que se espera el Alumno haya aprendido una vez curse la asignatura.
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    /**
     * Método que permite la impresión en pantalla de manera amigable para el usuario toda la información pertinente sobre una Asignatura en específico.
     */
    public void imprimirAsignatura() {
        System.out.println("\nLos datos de la Asignatura son los siguientes:"
                + "\n\tNombre:\t" + this.getNombre()
                + "\n\tClave:\t" + this.getClave()
                + "\n\tCreditos:\t" + this.getCreditos()
                + "\n\tHoras en el semestre:\t" + this.getHorasTotales()
                + "\n\tSemestre en el que se cursa:\t" + this.getSemestre()
                + "\n\tSeriación obligatoria antecedente:\t" + this.getSeriacionAntecedente()
                + "\n\tSeriación obligatoria subsecuente:\t" + this.getSeriacionSubsecuente()
                + "\n\tObjetivos de la materia:\t" + this.getObjetivo() );
    }
}
