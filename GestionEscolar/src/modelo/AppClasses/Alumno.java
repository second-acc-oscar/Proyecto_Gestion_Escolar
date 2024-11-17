package modelo.AppClasses;

/**
 * Clase que representa a un alumno genérico de la facultad de ingeniería.
 * 
 * @author Oscar Rojas
 */
public class Alumno {
    /**
     * El nombre del Alumno. Si tiene dos nombres, se almacena en la misma cadena.
     */
    private String nombre;
    
    /**
     * El primer apellido del Alumno.
     */
    private String apellidoPaterno;
    
    /**
     * El segundo apellido del Alumno.
     */
    private String apellidoMaterno;
    
    /**
     * El número de cuenta del Alumno es el identificador único de cada alumno dado de alta en el sistema y consta de nueve dígitos numéricos.
     */
    private int numeroDeCuenta;
    
    /**
     * Cadena que contiene la dirección física en la que vive el Alumno.
     */
    private String domicilio;
    
    /**
     * Dirección de correo electrónico del alumno formado por su nombre y apellidos.
     */
    private String correo;
    
    /**
     * Objeto que contiene toda la información sobre las materias que ha inscrito el Alumno a lo largo del tiempo y conforme a su avance curricular.
     */
    private HistorialAcademico historialAcademico;
    
    /**
     * Promedio acumulado de todas las materias inscritas desde que inició la carrera el Alumno.
     */
    private float promedioGeneral;
    
    /**
     * Edad en años del Alumno.
     */
    private int edad;
    
    /**
     * Número del semestre que debería estar cursando el Alumno de aprobar e inscribir todas sus materias de la manera prevista, concide con la cantidad de semestres que han pasado desde el ingreso del Alumno.
     */
    private int semestreRegular;
    
    /**
     * Número total de asignaturas que el Alumno ha inscrito desde que inició la carrera.
     */
    private int asignaturasInscritas;
    
    /**
     * Total de todas las asignaturas que el Alumno ha aprobado desde que inició la carrera.
     */
    private int asignaturasAprobadas;
    
    /**
     * El número de inscripción único del Alumno. Se asigna el más reciente computado hasta el momento.
     */
    private int numeroDeInscripcion;

    /**
     * Crea una nueva instancia de Alumno vacía.
     */
    public Alumno() {
    }

    /**
     * Crea una instancia de Alumno llena.
     * @param nombre El nombre del Alumno. Si tiene dos nombres, se almacena en la misma cadena.
     * @param apellidoPaterno El primer apellido del Alumno.
     * @param apellidoMaterno El segundo apellido del Alumno.
     * @param numeroDeCuenta El número de cuenta del Alumno es el identificador único de cada alumno dado de alta en el sistema y consta de nueve dígitos numéricos.
     * @param domicilio Cadena que contiene la dirección física en la que vive el Alumno.
     * @param correo Dirección de correo electrónico del alumno formado por su nombre y apellidos.
     * @param historialAcademico Objeto que contiene toda la información sobre las materias que ha inscrito el Alumno a lo largo del tiempo y conforme a su avance curricular.
     * @param promedioGeneral Promedio acumulado de todas las materias inscritas desde que inició la carrera el Alumno.
     * @param edad Edad en años del Alumno.
     * @param semestreRegular Número del semestre que debería estar cursando el Alumno de aprobar e inscribir todas sus materias de la manera prevista, concide con la cantidad de semestres que han pasado desde el ingreso del Alumno.
     * @param asignaturasInscritas Número total de asignaturas que el Alumno ha inscrito desde que inició la carrera.
     * @param asignaturasAprobadas Total de todas las asignaturas que el Alumno ha aprobado desde que inició la carrera.
     * @param numeroDeInscripcion El número de inscripción único del Alumno. Se asigna el más reciente computado hasta el momento.
     */
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int numeroDeCuenta, String domicilio, String correo, HistorialAcademico historialAcademico, float promedioGeneral, int edad, int semestreRegular, int asignaturasInscritas, int asignaturasAprobadas, int numeroDeInscripcion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroDeCuenta = numeroDeCuenta;
        this.domicilio = domicilio;
        this.correo = correo;
        this.historialAcademico = historialAcademico;
        this.promedioGeneral = promedioGeneral;
        this.edad = edad;
        this.semestreRegular = semestreRegular;
        this.asignaturasInscritas = asignaturasInscritas;
        this.asignaturasAprobadas = asignaturasAprobadas;
        this.numeroDeInscripcion = numeroDeInscripcion;
    }

    /**
     * Método que devuelve el nombre (o nombres) del Alumno.
     * @return Una cadena con el nombre del Alumno. Si tiene dos nombres, se encuentran concatenados en la misma variable.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre (o nombres) del Alumno.
     * @param nombre Una cadena con el nombre del Alumno. Si tiene dos nombres, se encuentran concatenados en la misma variable.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el apellido paterno (primer apellido) del Alumno.
     * @return Una cadena con el primer apellido del Alumno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno (primer apellido) del Alumno.
     * @param apellidoPaterno Una cadena con el primer apellido del Alumno.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que devuelve el apellido materno (segundo apellido) del Alumno.
     * @return Una cadena con el segundo apellido del Alumno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno (segundo apellido) del Alumno.
     * @param apellidoMaterno Una cadena con el segundo apellido del Alumno.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que devuelve el número de cuenta del Alumno.
     * @return Un número entero, el número de cuenta del Alumno.
     */
    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    /**
     * Método que establece el número de cuenta del Alumno.
     * @param numeroDeCuenta Un número entero, el número de cuenta del Alumno.
     */
    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    /**
     * Método que devuelve la dirección de domicilio del Alumno.
     * @return Una cadena con la dirección de domicilio del Alumno.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Método que establece la dirección de domicilio del Alumno.
     * @param domicilio Una cadena con la dirección de domicilio del Alumno.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Método que devuelve la dirección de correo electrónico del Alumno.
     * @return Una cadena con la dirección de correo electrónico del Alumno.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que establece la dirección de domicilio del Alumno.
     * @param correo Una cadena con la dirección de domicilio del Alumno.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que devuelve la información sobre el historial académico y las materias inscritas a lo largo del tiempo por el Alumno.
     * @return Un objeto con el historial académico del Alumno.
     */
    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

    /**
     * Método que establece la información sobre el historial académico y las materias inscritas a lo largo del tiempo por el Alumno.
     * @param historialAcademico Un objeto con el historial académico del Alumno.
     */
    public void setHistorialAcademico(HistorialAcademico historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    /**
     * Método que devuelve el promedio general del Alumno.
     * @return Un número de expresión decimal que contiene el promedio acumulado del Alumno hasta el momento.
     */
    public float getPromedioGeneral() {
        return promedioGeneral;
    }

    /**
     * Método que establece el promedio general del Alumno.
     * @param promedioGeneral Un número de expresión decimal que contiene el promedio acumulado del Alumno hasta el momento.
     */
    public void setPromedioGeneral(float promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    /**
     * Método que devuelve la edad del Alumno.
     * @return Un número entero, la edad en años del Alumno.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método que establece la edad del Alumno.
     * @param edad Un número entero, la edad en años del Alumno.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método que devuelve el número de semestres cursados del Alumno desde que inició la carrera.
     * @return Un número entero con el número de semestres cursados del Alumno desde que inició la carrera.
     */
    public int getSemestreRegular() {
        return semestreRegular;
    }

    /**
     * Método que establece el número de semestres cursados del Alumno desde que inició la carrera.
     * @param semestreRegular Un número entero con el número de semestres cursados del Alumno desde que inició la carrera.
     */
    public void setSemestreRegular(int semestreRegular) {
        this.semestreRegular = semestreRegular;
    }

    /**
     * Método que devuelve el número de asignaturas que ha inscrito el Alumno a lo largo de toda su carrera.
     * @return Un número entero, el número de asignaturas que ha inscrito el Alumno a lo largo de toda su carrera.
     */
    public int getAsignaturasInscritas() {
        return asignaturasInscritas;
    }

    /**
     * Método que establece el número de asignaturas que ha inscrito el Alumno a lo largo de toda su carrera.
     * @param asignaturasInscritas Un número entero, el número de asignaturas que ha inscrito el Alumno a lo largo de toda su carrera.
     */
    public void setAsignaturasInscritas(int asignaturasInscritas) {
        this.asignaturasInscritas = asignaturasInscritas;
    }

    /**
     * Método que devuelve el número de asignaturas que ha <b>aprobado</b> el Alumno desde su ingreso.
     * @return Un número entero, el número de asignaturas que ha <b>aprobado</b> el Alumno desde su ingreso.
     */
    public int getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    /**
     * Método que establece el número de asignaturas que ha <b>aprobado</b> el Alumno desde su ingreso.
     * @param asignaturasAprobadas Un número entero, el número de asignaturas que ha <b>aprobado</b> el Alumno desde su ingreso.
     */
    public void setAsignaturasAprobadas(int asignaturasAprobadas) {
        this.asignaturasAprobadas = asignaturasAprobadas;
    }

    /**
     * Método que devuelve el número de inscripción más reciente computado del Alumno.
     * @return Un número entero, el número de inscripción único más reciente computado del Alumno.
     */
    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
    }

    /**
     * Método que establece el número de inscripción más reciente computado del Alumno.
     * @param numeroDeInscripcion Un número entero, el número de inscripción único más reciente computado del Alumno.
     */
    public void setNumeroDeInscripcion(int numeroDeInscripcion) {
        this.numeroDeInscripcion = numeroDeInscripcion;
    }
    
    /**
     * Método que convierte el estado de los atributos relevantes (no incluído historial académico) de un objeto de tipo Alumno en una cadena con formato CSV.
     * @return El estado de los atributos del objeto en cadena, separados cada uno por comas (formato CSV).
     */
    public String toCSV() {
        String coma = ",";
        return nombre + coma + apellidoPaterno + coma + apellidoMaterno + coma + numeroDeCuenta + coma + domicilio + coma + correo + coma + promedioGeneral + coma + edad + coma + semestreRegular + coma + asignaturasInscritas + coma + asignaturasAprobadas;
    }

    /**
     * Método que parsea un objeto en una cadena.
     * @return El estado de los atributos del objeto en cadena.
     */
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", numeroDeCuenta=" + numeroDeCuenta + ", domicilio=" + domicilio + ", correo=" + correo + ", historialAcademico=" + historialAcademico + ", promedioGeneral=" + promedioGeneral + ", edad=" + edad + ", semestreRegular=" + semestreRegular + ", asignaturasInscritas=" + asignaturasInscritas + ", asignaturasAprobadas=" + asignaturasAprobadas + ", numeroDeInscripcion=" + numeroDeInscripcion + '}';
    }
}
