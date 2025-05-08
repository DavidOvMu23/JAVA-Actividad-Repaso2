package centro;

import java.util.ArrayList;

public class centro implements Icentro {

    //atributos
    protected String nombre;
    protected String direccion;
    protected ArrayList<alumno> alumnos = new ArrayList<alumno>();
    protected ArrayList<examen> examenes = new ArrayList<examen>();

    //constructor
    public centro(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAlumnos(ArrayList<alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void setExamenes(ArrayList<examen> examenes) {
        this.examenes = examenes;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<alumno> getAlumnos() {
        return alumnos;
    }

    public ArrayList<examen> getExamenes() {
        return examenes;
    }

    //metodos
    @Override
    public void registrarAlumno(alumno alumno) {
        if (alumnos.add(funciones.crearAlumno())) {
            System.out.println("Alumno añadido correctamente");
        } else {
            System.out.println("El alumno no se ha podido crear correctamente");
        }

        funciones.guardarAlumnos(alumnos);
    }

    @Override
    public void registrarExamen(examen examen) {
        if (examenes.add(funciones.crearExamen())) {
            System.out.println("Examen añadido correctemente");
        } else {
            System.out.println("El examen no se ha podido crear correctamente");
        }

        funciones.guardarExamenes(examenes);
    }

    @Override
    public void datosCentro() {
        funciones.mostrarDatosCentro(this);
    }

    @Override
    public void cargarAlumnos() {
        funciones.recuperarAlumnos(alumnos);
    }

}
