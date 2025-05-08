package centro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class funciones {

    public static Scanner sc = new Scanner(System.in);

    public static alumno crearAlumno() {
        alumno nuevoAlumno;
        System.out.println("");
        System.out.println("REGISTRAR ALUMNO:");
        System.out.print("Introduce el DNI del alumno a registrar: ");
        String DNI = sc.nextLine();

        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el primer apellido: ");
        String apellido1 = sc.nextLine();
        System.out.print("Introduce el segundo apellido: ");
        String apellido2 = sc.nextLine();
        String apellidos = apellido1 + " " + apellido2;

        nuevoAlumno = new alumno(DNI, nombre, apellidos);
        return nuevoAlumno;
    }

    public static examen crearExamen() {
        System.out.println("");
        System.out.println("REGISTRAR EXAMEN:");
        System.out.println("Selecciona un tipo de examen:");
        System.out.println("1. Oral");
        System.out.println("2. Escrito");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el ID a almacenar el examen: ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el nombre del examen: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el dia de realización del examen: ");
        int dia = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el mes de realización del examen: ");
        int mes = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el año de realización del examen: ");
        int anio = sc.nextInt();
        sc.nextLine();
        LocalDate fecha = LocalDate.of(anio, mes, dia);

        if (opcion == 1) {
            System.out.print("Introduce el nivel de satisfacción del examen: ");
            String satisfaccion = sc.nextLine();

            examen nuevoExamen = new examenOral(ID, nombre, fecha, satisfaccion);
            return nuevoExamen;

        } else if (opcion == 2) {
            System.out.print("Introduce la nota del examen : ");
            Double nota = sc.nextDouble();
            sc.nextLine();

            System.out.print("Introduce el tiempo invertido(min): ");
            int tiempoInvertido = sc.nextInt();
            sc.nextLine();

            examen nuevoExamen = new examenEscrito(ID, nombre, fecha, nota, tiempoInvertido);
            return nuevoExamen;

        } else {
            return null;
        }
    }

    public static void guardarAlumnos(ArrayList<alumno> alumnos) {
        String archivoAlumnos = ("src/data/alumnos.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoAlumnos))) {
            for (alumno a : alumnos) {
                bw.write(a.getDNI() + "#" + a.getNombre() + "#" + a.getApellidos());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("No se ha podido añadir a los alumnos");
        }
    }

    public static void guardarExamenes(ArrayList<examen> examenes) {
        String archivoExamenesEscritos = ("src/data/examenesEscritos.txt");
        String archivoExamenesOrales = ("src/data/examenesOrales.txt");

        for (examen e : examenes) {
            if (e instanceof examenEscrito) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoExamenesEscritos))) {
                    bw.write(e.getId() + "#" + e.getNombre() + "#" + e.getFecha() + "#" + ((examenEscrito) e).getNota() + "#" + ((examenEscrito) e).getTiempoInvertido());
                    bw.newLine();
                } catch (Exception ex) {
                    System.out.println("No se han podido guardar los examenesEscritos");
                }

            } else if (e instanceof examenOral) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoExamenesEscritos))) {
                    bw.write(e.getId() + "#" + e.getNombre() + "#" + e.getFecha() + "#" + ((examenOral) e).getSatisfaccion());
                    bw.newLine();
                } catch (Exception ex) {
                    System.out.println("No se han podido guardar los examenesOrales");
                }
            }
        }
    }

    public static void recuperarAlumnos(ArrayList<alumno> alumnos) {
        String archivoAlumnos = ("src/data/alumnos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoAlumnos))) {
            for (alumno a : alumnos) {
                String linea = br.readLine();
                String[] datos = linea.split("#");

                String DNI = datos[0];
                String nombre = datos[1];
                String apellidos = datos[2];

                alumno nuevoAlumno = new alumno(DNI, nombre, apellidos);
                alumnos.add(nuevoAlumno);
            }
        } catch (Exception e) {
            System.out.println("No se han podido recuperar los alumnos");
        }
    }

    public static void mostrarDatosCentro(centro c) {
        System.out.println("Nombre del centro: " + c.getNombre());
        System.out.println("Dirección del centro: " + c.getDireccion());
        System.out.println("Alumnos del centro: ");
        for (alumno a : c.getAlumnos()) {
            System.out.println(a.getDNI() + " " + a.getNombre() + " " + a.getApellidos());
            System.out.println("Estado: " + (a.comprobarAprobado() ? "Aprobado" : "No aprobado"));
        }
        System.out.println("Exámenes del centro: ");
        for (examen e : c.getExamenes()) {
            System.out.println(e.getId() + " " + e.getNombre() + " " + e.getFecha());
        }
    }

    public static void aisgnarExamenAlumno(alumno a, examen e) {
        a.asignarExamen(e);
    }

}
