package centro;

import java.util.ArrayList;

public class alumno {

    //atributos
    private String DNI;
    private String nombre;
    private String apellidos;
    private ArrayList<examen> examenesRealizados = new ArrayList<examen>();

    //constructor
    public alumno(String DNI, String nombre, String apellidos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //setters
    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setExamenesRealizados(ArrayList<examen> examenesRealizados) {
        this.examenesRealizados = examenesRealizados;
    }

    //getters
    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public ArrayList<examen> getExamenesRealizados() {
        return examenesRealizados;
    }

    //metodos
    public void asignarExamen(examen nuevoExamen) {
        this.examenesRealizados.add(nuevoExamen);
    }

    public boolean comprobarAprobado() {
        for (examen e : examenesRealizados) {
            if (e instanceof examenEscrito) {
                examenEscrito escrito = (examenEscrito) e;
                if (escrito.getNota() < 6 || escrito.getTiempoInvertido() >= 90) {
                    return false;
                }
            }
        }
        return true;
    }

}
