package PracticaParcial2;
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 0;

        Hospital gestionHospital = new Hospital();
        String url = "jdbc:mysql://localhost:3306/hospital";
        String usuario = "root";
        String pass = "";

        try {
            // Establecer la conexi�n a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, pass);
            gestionHospital.cargarDatos(conexion);

            while (opcion != 8) {
                System.out.println("1. Listar pacientes ");
                System.out.println("2. Agregar paciente ");
                System.out.println("3. Eliminar pacientes ");
                System.out.println("4. Asignar doctor de cabecera ");
                System.out.println("5. Filtrar por fecha ");
                System.out.println("6. Editar pacientes ");
                System.out.println("7. Salir ");

                System.out.println("Ingrese su opción: ");
                opcion = input.nextInt();

                input.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Lista de pacientes");
                       gestionHospital.mostrarListaPacientes(conexion, input, false);
                        break;
                    case 2:
                        System.out.println("Agregar pacientes");
                        gestionHospital.agregarPaciente(conexion, input);
                        break;
                    case 3:
                        System.out.println("Eliminar pacientes");
                        gestionHospital.mostrarListaPacientes(conexion, input, false);
                        gestionHospital.eliminarPaciente(conexion, input);
                        break;
                    case 4:
                        System.out.println("Asignación de doctores");
                        gestionHospital.asignarDoctor(conexion, input);
                        break;
                    case 5:
                        System.out.println("Filtrar por fecha");
                        gestionHospital.mostrarListaPacientes(conexion,input,true);
                        break;
                    case 6:
                        System.out.println("Editar pacientes");
                        break;
                    case 7:

                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}