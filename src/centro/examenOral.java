package centro;

import java.time.LocalDate;

public class examenOral extends examen {

    //atributos
    private String satisfaccion;

    //constructor
    public examenOral(int id, String nombre, LocalDate fecha, String satisfaccion) {
        super(id, nombre, fecha);
        this.satisfaccion = satisfaccion;
    }

    //setters
    public void setSatisfaccion(String satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    //getters
    public String getSatisfaccion() {
        return satisfaccion;
    }
}
