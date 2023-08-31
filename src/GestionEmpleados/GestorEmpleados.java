package GestionEmpleados;
import java.util.ArrayList;
import java.util.Scanner;
public class GestorEmpleados
{
    public static Scanner input = new Scanner(System.in);
    public static int generarID = 0;
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        int opcion = 0;
        
        while(opcion != 5){
            System.out.println("Gestor de empleados: ");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opcion: ");
            opcion = input.nextInt();
            switch (opcion){
                case 1:
                    agregarEmpleado(listaEmpleados);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    for (Empleado empleado:listaEmpleados) {
                        System.out.println(empleado.toString());
                    }
                    while(true){
                        System.out.println("Ingrese cualquier caracter para volver al menu: ");
                        input.nextLine();
                        String a;
                        a = input.nextLine();

                        break;
                    }
                case 5:
                    break;
            }

        }

    }
    public static void agregarEmpleado(ArrayList<Empleado> listaEmpleado){
        int opcionEmpleado = 0;
        Empleado nuevoEmpleado;
        int id = generarID;
        String nombreEmpleado;
        double sueldoEmpleado, ventasRealizadas;
        int horas;
        System.out.println("Ingrese el tipo de empleado a agregar: ");
        System.out.println("1. Por hora");
        System.out.println("2. Asalariado");
        System.out.println("3. Por comision");
        opcionEmpleado = input.nextInt();

        input.nextLine();
        System.out.println("Ingrese el nombre del empleado: ");
        nombreEmpleado = input.nextLine();

        System.out.println("Ingrese el sueldo del empleado: ");
        sueldoEmpleado = input.nextInt();

        if(opcionEmpleado == 1) {
            System.out.println("Ingrese la cantidad de horas trabajadas: ");
            horas = input.nextInt();

            nuevoEmpleado = new EmpleadoPorHoras(id, nombreEmpleado, sueldoEmpleado, horas);
            listaEmpleado.add(nuevoEmpleado);
        }
        if(opcionEmpleado == 2){
            nuevoEmpleado = new EmpleadoAsalariado(id,nombreEmpleado,sueldoEmpleado);
            listaEmpleado.add(nuevoEmpleado);
        }
        if(opcionEmpleado == 3){
            System.out.println("Ingrese el monto de ventas realizadas: ");
            ventasRealizadas = input.nextInt();

            nuevoEmpleado = new EmpleadoComision(id, nombreEmpleado, sueldoEmpleado, ventasRealizadas);
            listaEmpleado.add(nuevoEmpleado);
        }
        generarID++;
        }
    }

