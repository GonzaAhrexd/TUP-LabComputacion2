package practicaParcialV2;

import java.sql.*;
import java.util.Scanner;

public class Hospital {

    public void agregarPaciente(Paciente paciente) {
        String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, fecha_ingreso, doctor) VALUES ('"
                + paciente.getNombre() + "', " + paciente.getEdad() + ", '" + paciente.getHistorialMedico() + "', '"
                + paciente.getFechaIngreso() + "', '" + paciente.getDoctor() + "')";
        DBHelper.ejecutarConsulta(consulta);
    }

    public void listarPacientes() {
        String consulta = "SELECT * FROM `pacientes`";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }


    private void listarPacientes(ResultSet resultadoPacientes) {

        if (resultadoPacientes != null) {
            try {
                System.out.println("ID\tNombre\t  Edad\tHistorial \tFecha de ingreso\tDoctor");

                // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
                while (resultadoPacientes.next()) {
                    int id = resultadoPacientes.getInt("id");
                    String nombre = resultadoPacientes.getString("nombre");
                    int edad = resultadoPacientes.getInt("edad");
                    String historialMedico = resultadoPacientes.getString("historial_medico");
                    Date fecha_ingreso = resultadoPacientes.getDate("fecha_ingreso");
                    int doctor = resultadoPacientes.getInt("doctor");

                    // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
                    System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + historialMedico + "\t" + fecha_ingreso.toString() + "\t \t \t" +  doctor);

                    // Cierra el ResultSet y la declaraci�n para liberar recursos.

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void asignarDoctores(String nombreDoctor, String nombrePaciente){
        String consulta = "UPDATE pacientes SET doctor = (SELECT id FROM doctores WHERE nombre = '"+nombreDoctor+"') WHERE nombre = '"+nombrePaciente+"'";
        DBHelper.ejecutarConsulta(consulta);
    }
    public void listarPacientesEntreFechas(Date fecha1, Date fecha2) {

        String consulta = "SELECT * FROM `pacientes` WHERE `fecha_ingreso` BETWEEN '"+fecha1+"' AND '"+fecha2+"' ORDER BY `doctor` ASC\n";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }
    public  void eliminarPaciente(String nombre){
        String consulta = "DELETE FROM `pacientes` WHERE `pacientes`.`nombre` = '"+nombre+"'";
        DBHelper.ejecutarConsulta(consulta);
    }
}