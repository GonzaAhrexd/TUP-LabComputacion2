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


    private static void agregarPaciente(Connection conexion, Scanner scanner) throws SQLException {
        // Solicita al usuario que ingrese los detalles del estudiante
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Legajo: ");
        String legajo = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Consulta SQL para insertar un nuevo estudiante en la base de datos.
        // Utiliza signos de interrogaci�n como marcadores de posici�n para los valores.
        String consulta = "INSERT INTO estudiantes (nombre, apellido, legajo, dni, fecha_nacimiento, direccion, telefono, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setString(1, nombre); // Asigna el valor de nombre al primer marcador de posici�n
        preparedStatement.setString(2, apellido); // Asigna el valor de apellido al segundo marcador de posici�n
        preparedStatement.setString(3, legajo); // Asigna el valor de legajo al tercer marcador de posici�n
        preparedStatement.setString(4, dni); // Asigna el valor de dni al cuarto marcador de posici�n
        preparedStatement.setString(5, fechaNacimiento); // Asigna el valor de fecha de nacimiento al quinto marcador de posici�n
        preparedStatement.setString(6, direccion); // Asigna el valor de direcci�n al sexto marcador de posici�n
        preparedStatement.setString(7, telefono); // Asigna el valor de tel�fono al s�ptimo marcador de posici�n
        preparedStatement.setString(8, email); // Asigna el valor de email al octavo marcador de posici�n

        // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
        int filasAfectadas = preparedStatement.executeUpdate();

        // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
        if (filasAfectadas > 0) {
            System.out.println("Estudiante agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el estudiante.");
        }

        // Cierra el PreparedStatement para liberar recursos.
        preparedStatement.close();
    }
}