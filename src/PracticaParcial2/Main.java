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
                System.out.println("3. Listar pacientes ");
                System.out.println("4. Eliminar pacientes ");
                System.out.println("5. Asignar doctor de cabecera ");
                System.out.println("6. Filtrar por fecha ");
                System.out.println("7. Editar pacientes ");
                System.out.println("8. Salir ");

                System.out.println("Ingrese su opción: ");
                opcion = input.nextInt();


                switch (opcion) {
                    case 1:
                        System.out.println("Lista de pacientes");
                       gestionHospital.mostrarListaPacientes(conexion);
                        break;
                    case 2:
                        System.out.println("Agregar pacientes");
                        break;
                    case 3:
                        System.out.println("Listar pacientes");
                        break;
                    case 4:
                        System.out.println("Eliminar pacientes");
                        break;
                    case 5:
                        System.out.println("Asignación de doctores");
                        break;
                    case 6:
                        System.out.println("Filtrar por fecha");
                        break;
                    case 7:
                        System.out.println("Editar pacientes");
                        break;
                    case 8:

                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}