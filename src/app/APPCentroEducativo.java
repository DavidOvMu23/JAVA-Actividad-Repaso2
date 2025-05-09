package app;

import centro.alumno;
import centro.centro;
import centro.examenEscrito;
import centro.examenOral;
import java.util.Scanner;

public class APPCentroEducativo {

    public static Scanner sc = new Scanner(System.in);
    public static centro centr = new centro("SuperCentro", "Ontinyent");
    public static alumno clumn = new alumno(null, null, null);
    public static examenOral examenOra = new examenOral(0, null, null, null);
    public static examenEscrito examenEscrit = new examenEscrito(0, null, null, 0, 0);

    public static void main(String[] args) {
        boolean salir = false;

        do {
            System.out.println("Seleccione una de las siguientes opciones:");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Registrar examen");
            System.out.println("3. Asignar examen a alumno");
            System.out.println("4. Imprimir datos centro");
            System.out.println("5. Cargar datos alumnos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    centr.registrarAlumno(clumn);
                    break;

                case 2:
                    centr.registrarExamen(examenOra);
                    break;

                case 3:
                    centr.asignarExamen(clumn, examenEscrit);
                    break;

                case 4:
                    centr.datosCentro();
                    break;

                case 5:
                    centr.cargarAlumnos();
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }

        } while (!salir);
    }
}
