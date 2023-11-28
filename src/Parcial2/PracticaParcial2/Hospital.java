package Parcial2.Parcial.PracticaParcial2;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

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

    public void mostrarListaPacientes(Connection conexion, Scanner input, boolean filtrarFecha) throws SQLException {
        String fechaInferior = "", fechaSuperior = "";
        int dia1 = 0, mes1 = 0, year1= 0, dia2= 0, mes2= 0, year2= 0;
        if(filtrarFecha){
            System.out.println("Ingrese la fecha inferior ");
            System.out.println("Ingrese el día: ");
            dia1 = input.nextInt();
            System.out.println("Ingrese el mes: ");
            mes1 = input.nextInt();
            System.out.println("Ingrese el año: ");
            year1 = input.nextInt();

            System.out.println("Ingrese la fecha superior ");
            System.out.println("Ingrese el día: ");
            dia2 = input.nextInt();
            System.out.println("Ingrese el mes: ");
            mes2 = input.nextInt();
            System.out.println("Ingrese el año: ");
            year2 = input.nextInt();
        }

        ResultSet resultadoPacientes;
        Statement statementPacientes = conexion.createStatement();
        if(!filtrarFecha) {
            resultadoPacientes = statementPacientes.executeQuery("SELECT * FROM pacientes");
        }else{
            PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM `pacientes` WHERE `fecha_ingreso` BETWEEN ? AND ? ORDER BY `fecha_ingreso` ASC\n");

            Date fechaInf = new Date(year1-1900,mes1-1,dia1);

            Date fechaSup = new Date(year2-1900,mes2-1,dia2);

            preparedStatement.setDate(1, fechaInf); // Asigna el valor de nombre al primer marcador de posici�n
            preparedStatement.setDate(2, fechaSup); // Asigna el valor de apellido al segundo marcador de posici�n

            resultadoPacientes = preparedStatement.executeQuery();
        }


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
    public static void eliminarPaciente(Connection conexion, Scanner scanner) throws SQLException {

        scanner.nextLine();
        int id = 0;
        System.out.println("Ingrese el nombre del paciente a  eliminar: ");
        String nombre =  scanner.nextLine();
        String consultaExistencia = "SELECT * FROM pacientes WHERE nombre = ?";
        PreparedStatement preparedStatementExistencia = conexion.prepareStatement(consultaExistencia);
        preparedStatementExistencia.setString(1, nombre); // Establece el valor del marcador de posici�n.
        ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();

        // Si no se encuentra ning�n estudiante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
        if (!resultadoExistencia.next()) {
            System.out.println("El paciente no existe.");
            preparedStatementExistencia.close();
            return;
        }

        // Consulta SQL para eliminar el estudiante de la base de datos.
        String consulta = "DELETE FROM pacientes WHERE nombre = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setString(1, nombre); // Establece el valor del marcador de posici�n.

        // Ejecuta la consulta SQL y obtiene el n�mero de filas afectadas.
        int filasAfectadas = preparedStatement.executeUpdate();

        // Verifica si la eliminaci�n fue exitosa y muestra un mensaje apropiado.
        if (filasAfectadas > 0) {
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el paciente.");
        }

        // Cierra el PreparedStatement para liberar recursos.
        preparedStatement.close();
    }
    public static void asignarDoctor(Connection conexion, Scanner scanner) throws SQLException {
        System.out.println("Ingrese el id del paciente a asignar doctor: ");
        int idPaciente = scanner.nextInt();

        String consultaExistencia = "SELECT * FROM pacientes WHERE id = ?";
        PreparedStatement preparedStatementExistencia = conexion.prepareStatement(consultaExistencia);
        preparedStatementExistencia.setInt(1, idPaciente); // Establece el valor del marcador de posici�n.
        ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();

        // Si no se encuentra ning�n estudiante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
        if (!resultadoExistencia.next()) {
            System.out.println("El estudiante no existe.");
            preparedStatementExistencia.close();
            return;
        }


        System.out.println("Ingrese el id  del doctor que se  le quiere asignar");
        int idDoctor  = scanner.nextInt();

        String consulta = "UPDATE pacientes SET doctor = ?  WHERE id = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setInt(1, idDoctor);
        preparedStatement.setInt(2, idPaciente);

        int filasAfectadas = preparedStatement.executeUpdate();

        // Verifica si la edici�n fue exitosa y muestra un mensaje apropiado.
        if (filasAfectadas > 0) {
            System.out.println("Estudiante editado exitosamente.");
        } else {
            System.out.println("No se pudo editar el estudiante.");
        }

        // Cierra el PreparedStatement para liberar recursos.
        preparedStatement.close();
    }


}

