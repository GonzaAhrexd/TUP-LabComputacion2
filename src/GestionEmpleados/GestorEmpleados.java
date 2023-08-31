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
                case 1: //Agregar
                    int opcionEmpleado = opcionesEmpleado();
                    agregarEmpleado(listaEmpleados, opcionEmpleado);
                    break;
                case 2: //Editar
                    int idEditar;
                    System.out.println("Ingrese el id del empleado a editar: ");
                    idEditar = input.nextInt();
                    editarEmpleado(listaEmpleados,idEditar);
                    break;
                case 3: //Eliminar
                    int idEliminar;
                    System.out.println("Ingrese la id del usuario a eliminar: ");
                    idEliminar = input.nextInt();
                    eliminarEmpleado(listaEmpleados, idEliminar);
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
    public static void agregarEmpleado(ArrayList<Empleado> listaEmpleado, int opcionEmpleado){
        int id = generarID;
        Empleado nuevoEmpleado;
        String nombreEmpleado;
        double sueldoEmpleado, ventasRealizadas;
        int horas;

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

        public static void eliminarEmpleado(ArrayList <Empleado> listaEmpleado, int idEliminar){
            int i =0;
        for (Empleado empleado:
                 listaEmpleado) {
                if(empleado.getId() == idEliminar){
                    listaEmpleado.remove(i);
                    break;
                }
                i++;
            }
        }

        public static void editarEmpleado(ArrayList <Empleado> listaEmpleado, int idEditar){
            for (Empleado empleado:listaEmpleado) {
                if(idEditar == empleado.getId()){

                }
            }
        }
        public static int opcionesEmpleado(){
        int opcionEmpleado = 0;
        System.out.println("Ingrese el tipo de empleado a agregar: ");
        System.out.println("1. Por hora");
        System.out.println("2. Asalariado");
        System.out.println("3. Por comision");
        opcionEmpleado = input.nextInt();

        return opcionEmpleado;
    }
    public static Empleado crearEmpleado(){
        int id = generarID;
        Empleado nuevoEmpleado;
        String nombreEmpleado;
        double sueldoEmpleado, ventasRealizadas;
        int horas;

        int opcionEmpleado = opcionesEmpleado();

        input.nextLine();
        System.out.println("Ingrese el nombre del empleado: ");
        nombreEmpleado = input.nextLine();

        System.out.println("Ingrese el sueldo del empleado: ");
        sueldoEmpleado = input.nextInt();

        if(opcionEmpleado == 1) {
            System.out.println("Ingrese la cantidad de horas trabajadas: ");
            horas = input.nextInt();

            nuevoEmpleado = new EmpleadoPorHoras(id, nombreEmpleado, sueldoEmpleado, horas);
            generarID++;
            return nuevoEmpleado;
        }
        if(opcionEmpleado == 2){
            nuevoEmpleado = new EmpleadoAsalariado(id,nombreEmpleado,sueldoEmpleado);
            generarID++;
            return nuevoEmpleado;
        }
        if(opcionEmpleado == 3){
            System.out.println("Ingrese el monto de ventas realizadas: ");
            ventasRealizadas = input.nextInt();
            nuevoEmpleado = new EmpleadoComision(id, nombreEmpleado, sueldoEmpleado, ventasRealizadas);
            generarID++;
            return nuevoEmpleado;
        }
        return null;
    }
}

