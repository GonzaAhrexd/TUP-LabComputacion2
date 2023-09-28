package ModeloExamenPractica;

import PracticaParcial.Practica3.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;
class GestionarHabitaciones {
    public static Scanner input = new Scanner(System.in);
    private ArrayList<Habitaciones> listaHabitaciones = new ArrayList<Habitaciones>();

    Habitaciones habitacion1 = new Habitaciones(5,6,"Libre") ;
    Habitaciones habitacion2 = new Habitaciones(6,8,"Libre");
    Habitaciones habitacion3 =  new Habitaciones(4,4,"Libre");
    Habitaciones habitacion4 =  new Habitaciones(3,4,"Libre");
    Habitaciones habitacion5 =  new Habitaciones(2,3,"Libre");
    Habitaciones habitacion6 =  new Habitaciones(4,4,"Libre");

    public GestionarHabitaciones() {
        this.listaHabitaciones.add(habitacion1);
        this.listaHabitaciones.add(habitacion2);
        this.listaHabitaciones.add(habitacion3);
        this.listaHabitaciones.add(habitacion4);
        this.listaHabitaciones.add(habitacion5);
        this.listaHabitaciones.add(habitacion6);
    }

    public void reservar(){
        int cantidadHuespedes;
        int indice;
        Huespedes[] listaHuespedes;

        System.out.println("Ingrese el id de la habitación a reservar: ");
        indice = input.nextInt();
        input.nextLine();
        System.out.println("Cuantos huespedes van a ocupar la habitación? ");
        cantidadHuespedes = input.nextInt();

        listaHuespedes = new Huespedes[cantidadHuespedes];
        input.nextLine();

        if(cantidadHuespedes <= this.listaHabitaciones.get(indice).getCapacidad_de_huespedes()){

            for (int i = 0; i < cantidadHuespedes ; i++) {
                Huespedes huesped;
                String nombre, apellido;
                int edad, dni;

                System.out.println("Ingrese el nombre del huesped: ");
                nombre = input.nextLine();
                System.out.println("Ingrese el apellido del huesped: ");
                apellido = input.nextLine();

                System.out.println("Ingrese la edad del huesped: ");
                edad = input.nextInt();
                input.nextLine();

                System.out.println("Ingrese el dni del huesped: ");
                dni = input.nextInt();
                input.nextLine();

                huesped = new Huespedes(nombre,apellido,edad,dni);
                listaHuespedes[i] = huesped;
            }
            this.listaHabitaciones.get(indice).setListaHuespedes(listaHuespedes);
            this.listaHabitaciones.get(indice).setEstado("Ocupado");
        }
    }

    public void eliminarReserva(){
        int indice;
        System.out.println("Ingrese el número de habitación de la que quiere eliminar la reserva: ");
        indice = input.nextInt();
        this.listaHabitaciones.get(indice).setEstado("Libre");
        this.listaHabitaciones.get(indice).setListaHuespedes(null);
    }

    public void mostrarLista() {

        System.out.println("Número \t Camas \t Capacidad \t Estado \t Huespedes");
        int i = 0;
        String huespedes = "";

        for (Habitaciones habitacion: listaHabitaciones) {
  /*          if(habitacion.getListaHuespedes() != null){
                for (Huespedes huesped: habitacion.getListaHuespedes()) {
                    huespedes = huesped.getNombre() + " " + huesped.getApellido() + ",";
                }
            };
            System.out.println(i + "\t" + habitacion.getCantidad_de_camas() + "\t" + habitacion.getCapacidad_de_huespedes() + "\t" + habitacion.getEstado() +  habitacion.mostrarInterfazRelevante());
*/
            System.out.println(i + "\t\t " + habitacion.mostrarInformacionRelevante());
            i++;
        }

    }


}



