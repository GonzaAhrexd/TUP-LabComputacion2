package GestionEmpleados;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GestorEmpleados
{
    public static Scanner input = new Scanner(System.in); //Scanner global para usarlo tanto en main como en los procedimientos
    public static int generarID = 0; //Variable global para ir generando Ids que van aumentando a medida que se agregan nuevos usuarios, así nunca se repite
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        int opcion = 0;
        while(opcion != 7){
            //Menu para ingresar las opciones
            System.out.println("**************************");
            System.out.println("Gestor de empleados: ");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Mostrar sueldos");
            System.out.println("6. Calcular impuestos");
            System.out.println("7. Salir");
            System.out.println("**************************");
            System.out.println("Ingrese su opcion: ");
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Ingrese un número válido.");
                input.nextLine();
                continue;
            }
            switch (opcion){
                case 1: //Agregar
                    agregarEmpleado(listaEmpleados);
                    break;
                case 2: //Editar
                    editarEmpleado(listaEmpleados);
                    break;
                case 3: //Eliminar
                    eliminarEmpleado(listaEmpleados);
                    break;
                case 4: //Mostrar valores
                   mostrarValores(listaEmpleados);
                    break;
                case 5: //mostrar sueldos
                    mostrarSueldos(listaEmpleados);
                    break;
                case 6: //mostrar impuestos
                    mostrarImpuestos(listaEmpleados);
                    break;
                case 7: //salir
                    break;
            }
        }
    }
    //Procedimiento para agregar empleados
    public static void agregarEmpleado(ArrayList<Empleado> listaEmpleado){
        Empleado nuevoEmpleado = crearEmpleado(generarID); //crea un nuevo empleado utilizando el procedimiento para crear empleados pasando la variable global de generarId
        listaEmpleado.add(nuevoEmpleado); //Agrega a la lista de empleados el nuevo empleado creado
        }

        //Procedimiento para eliminar los empleados
        public static void eliminarEmpleado(ArrayList <Empleado> listaEmpleado){
            //Se pregunta por la Id del usuario que se desea eliminar
            int idEliminar;
            System.out.println("Ingrese la id del usuario a eliminar: ");
            idEliminar = input.nextInt();
        for (Empleado empleado: listaEmpleado) { //Se recorre la lista de empleados
                if(empleado.getId() == idEliminar){ //Si se encuentra el Id...
                    listaEmpleado.remove(listaEmpleado.indexOf(empleado)); //Se elimina de la lista utilizando el indice actual de empleado
                    break;
                }
            }
        }
    //Metodo para editar empleados
        public static void editarEmpleado(ArrayList <Empleado> listaEmpleado){
            //Se pregunta por la id del empleado a editar
            int idEditar;
            System.out.println("Ingrese el id del empleado a editar: ");
            idEditar = input.nextInt();

            for (Empleado empleado:listaEmpleado) { //Se recorre la lista de empleados
                if(idEditar == empleado.getId()){ //Si se encuentra el Id...
                    Empleado nuevoEmpleado = crearEmpleado(empleado.getId()); //Se crea un nuevo empleado utilizando el procedidmiento crearEmpleado
                    listaEmpleado.set(listaEmpleado.indexOf(empleado), nuevoEmpleado); //Se asigna a la posicion actual, el objeto creado recien
                }
            }
        }
        //Función que devuelve la opción de empleado a elegir
        public static int opcionesEmpleado(){
        int opcionEmpleado = 0;
        System.out.println("Ingrese el tipo de empleado a agregar: ");
        System.out.println("1. Por hora");
        System.out.println("2. Asalariado");
        System.out.println("3. Por comision");
        
        opcionEmpleado = input.nextInt();

        return opcionEmpleado;
    }
    //Función para crear empleados que puede ser reutilizado tanto para agregar como modificar empleados
    public static Empleado crearEmpleado(int obtenerId){
        int id = obtenerId;
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
        //GenerarID++ hace que nuestra variable global se vaya incrementando para que no existan Ids repetidos
        return null;
    }
    //Procedimiento para ingresar un caracter antes de continuar
    public static void continuar(){
        while(true){
            System.out.println("Ingrese cualquier caracter para volver al menu: ");
            input.nextLine();
            String a;
            a = input.nextLine();
            break;
        }
    }
    //Muestra los valores de los empleados
    public static void mostrarValores(ArrayList<Empleado> listaEmpleados){
        for (Empleado empleado:listaEmpleados) { //Recorre toda la lista y utiliza el metodo toString
            System.out.println(empleado.toString());
        }
        continuar();
    }
    //Mostrar sueldos
    public static void mostrarSueldos(ArrayList<Empleado> listaEmpleado){
        int idConsultar;
        System.out.println("Ingrese el id del sueldo de empleado a consultar: ");
        idConsultar = input.nextInt();

        for (Empleado empleado:listaEmpleado) { //Recorre la lista en busca de la id ingresada
            if(idConsultar == empleado.getId()){ //Si se encuentra, se
                System.out.println("Sueldo de " + empleado.getNombre() + ":" + empleado.calcularSueldo());
            }
        }
        continuar();
    }
    //Mostrar impuestos

    public static void mostrarImpuestos(ArrayList<Empleado> listaEmpleado){
        int idConsultar;
        System.out.println("Ingrese el id del sueldo de empleado a consultar: ");
        idConsultar = input.nextInt();

        for (Empleado empleado:listaEmpleado) {
            if(idConsultar == empleado.getId()){
                System.out.println("Impuestos a pagar por " + empleado.getNombre() + ":" + empleado.calcularImpuesto());
            }
        }
        continuar();
    }

}