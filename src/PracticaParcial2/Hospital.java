package PracticaParcial2;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private ArrayList<Doctores> listaDoctores = new ArrayList<>();

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Doctores> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctores> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public void cargarDatos(Connection conexion) throws SQLException {
        // Crea una declaraci�n SQL para ejecutar una consulta de selecci�n.
        Statement statementPacientes = conexion.createStatement();
        Statement statementDoctores = conexion.createStatement();
        // Define la consulta SQL para obtener ambas tablas.
        String consultaPacientes = "SELECT * FROM pacientes";
        String consultaDoctores = "SELECT * FROM doctores";

        // Ejecuta la consulta SQL y almacena los resultados en un ResultSet.
        ResultSet resultadoPacientes = statementPacientes.executeQuery(consultaPacientes);
        ResultSet resultadosDoctores = statementDoctores.executeQuery(consultaDoctores);

        // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
        while (resultadoPacientes.next()) {
            int id = resultadoPacientes.getInt("id");
            String nombre = resultadoPacientes.getString("nombre");
            int edad = resultadoPacientes.getInt("edad");
            String historialMedico = resultadoPacientes.getString("historial_medico");
            Date fecha_ingreso = resultadoPacientes.getDate("fecha_ingreso");
            int doctor = resultadoPacientes.getInt("doctor");

            Paciente cargandoPaciente = new Paciente(id, nombre, edad, historialMedico, fecha_ingreso, doctor);

            this.listaPacientes.add(cargandoPaciente);

            // Cierra el ResultSet y la declaraci�n para liberar recursos.

        }
        resultadoPacientes.close();
        statementPacientes.close();
    }

    public void mostrarListaPacientes(Connection conexion) throws SQLException {
        Statement statementPacientes = conexion.createStatement();
        String consultaPacientes = "SELECT * FROM pacientes";
        ResultSet resultadoPacientes = statementPacientes.executeQuery(consultaPacientes);


        System.out.println("ID\tNombre\tEdad\tHistorial médico\tFecha de ingreso\tDoctor");

        // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
        while (resultadoPacientes.next()) {
            int id = resultadoPacientes.getInt("id");
            String nombre = resultadoPacientes.getString("nombre");
            int edad = resultadoPacientes.getInt("edad");
            String historialMedico = resultadoPacientes.getString("historial_medico");
            Date fecha_ingreso = resultadoPacientes.getDate("fecha_ingreso");
            int doctor = resultadoPacientes.getInt("doctor");

            // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
            System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + historialMedico + "\t" + fecha_ingreso.toString() + "\t" + doctor);


            // Cierra el ResultSet y la declaraci�n para liberar recursos.

        }
        resultadoPacientes.close();
        statementPacientes.close();
    }


    public static void agregarPaciente(Connection conexion, Scanner scanner) throws SQLException {
        // Solicita al usuario que ingrese los detalles del estudiante
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Historial  médico: ");
        String historial_medico = scanner.nextLine();
        System.out.print("Fecha de ingreso: ");
        System.out.println("Ingrese el día: ");
        int dia = scanner.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = scanner.nextInt();
        System.out.println("Ingrese el año: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el id del doctor: ");
        int doctor = scanner.nextInt();
        scanner.nextLine();
        Date fecha_ingreso = new Date(year, mes, dia);

        // Consulta SQL para insertar un nuevo estudiante en la base de datos.
        // Utiliza signos de interrogaci�n como marcadores de posici�n para los valores.
        String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico , fecha_ingreso,doctor) " +
                "VALUES (?, ?, ?, ?, ?)";

        // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setString(1, nombre); // Asigna el valor de nombre al primer marcador de posici�n
        preparedStatement.setInt(2, edad); // Asigna el valor de apellido al segundo marcador de posici�n
        preparedStatement.setString(3, historial_medico); // Asigna el valor de legajo al tercer marcador de posici�n
        preparedStatement.setDate(4, fecha_ingreso); // Asigna el valor de dni al cuarto marcador de posici�n
        preparedStatement.setInt(5, doctor); // Asigna el valor de fecha de nacimiento al quinto marcador de posici�n
        // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
        int filasAfectadas = preparedStatement.executeUpdate();

        // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
        if (filasAfectadas > 0) {
            System.out.println("Paciente agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el paciente.");
        }

        // Cierra el PreparedStatement para liberar recursos.
        preparedStatement.close();
    }
}