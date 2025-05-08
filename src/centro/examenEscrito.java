package centro;

import java.time.LocalDate;

public class examenEscrito extends examen {

    //atributos
    private double nota;
    private int tiempoInvertido;

    //constrcutor
    public examenEscrito(int id, String nombre, LocalDate fecha, double nota, int tiempoInvertido) {
        super(id, nombre, fecha);
        this.nota = nota;
        this.tiempoInvertido = tiempoInvertido;
    }

    //getters
    public double getNota() {
        return nota;
    }

    public int getTiempoInvertido() {
        return tiempoInvertido;
    }

    //setters
    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setTiempoInvertido(int tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
    }

}
