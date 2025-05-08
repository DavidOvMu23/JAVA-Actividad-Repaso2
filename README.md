Aplicación de Gestión de Graduación de Alumnos

Un centro educativo requiere una aplicación para decidir qué alumnos se graduarán. Este centro, que se caracteriza por un nombre y una dirección, gestiona un listado de alumnos y exámenes.

Cada alumno tiene: DNI (Identificador único), Nombre, Apellidos y Exámenes realizados.

Los exámenes pueden ser de dos tipos:

- Escritos: Se almacenan los siguientes datos:
  - ID único
  - Nombre (Ej: 1ESO_MAT, 2ESO_ING, etc.)
  - Fecha de realización
  - Nota numérica (Entre 0 y 10)
  - Tiempo invertido en minutos (Debe ser menor a 90 min para aprobar)
- Orales: Se almacenan los siguientes datos:
  - ID único
  - Nombre (Ej: 1ESO_MAT, 2ESO_ING, etc.)
  - Fecha de realización
  - Nivel de satisfacción (Insuficiente, Suficiente o Excelente)

Un alumno aprueba todos sus exámenes si:

- Exámenes escritos: Nota mayor o igual a 6 y tiempo inferior a 90 min.
- Exámenes orales: Todos deben ser al menos suficientes.

Clases necesarias:
Se deben implementar clases teniendo en cuenta herencia (Clases abstractas) y polimorfismo (Interfaces).

Métodos requeridos:

- Registrar alumno en un centro educativo. Si el DNI ya existe, lanzar RegistroAlumnoException.
- Registrar examen en el sistema. Si el ID ya existe, lanzar RegistroExamenException.
- Añadir examen a un alumno (recibe ID examen y ID alumno). Validaciones:
  - El alumno no puede tener más de 5 exámenes registrados.
  - La calificación debe cumplir los requisitos de aprobación.
  - Si el examen no existe, el alumno no pertenece al centro o alguna condición falla, lanzar ExamenAlumnoException.
- Obtener información del centro educativo con el siguiente formato:
  NOMBRE_CENTRO
  - (DNI_ALUMNO) NOMBRE_ALUMNO
    Exámenes:
    - ID EXAMEN. NOMBRE_EXAMEN (TIPO - Aprobado/Suspenso)
    - ID EXAMEN. NOMBRE_EXAMEN (TIPO - Aprobado/Suspenso)
      Aprueba el curso: SÍ/NO

Aplicación APPCentroEducativo.java:
La aplicación debe incluir un centro registrado por defecto (SuperCentro, Ontinyent) y un menú con opciones:

Seleccione una de las siguientes opciones:

1. Registrar alumno
2. Registrar examen
3. Asignar examen a alumno
4. Imprimir datos centro
5. Cargar datos alumnos desde un fichero
6. Salir

El fichero de alumnos tendrá un formato similar:
123456789X#Carlos#Ruiz Tercero
987654321Y#Pedro#Menéndez Quemado
