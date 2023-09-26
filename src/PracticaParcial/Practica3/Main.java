package PracticaParcial.Practica3;
import java.util.Scanner;
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Concesionaria listaConcesionaria = new Concesionaria();


        int opcion = 0;
        int opcionVehiculo;
        int numeroCuenta;
        String marca;
        String modelo;
        double precio;

        while (true) {
            System.out.println("1. Agregar vehículos ");
            System.out.println("2. Editar vehículos");
            System.out.println("3. Eliminar vehículos");
            System.out.println("4. Mostrar vehículos");
            System.out.println("5. Guardar vehículos");
            System.out.println("6. Cargar vehículos");

            System.out.println("7. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = input.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("1. Coche");
                    System.out.println("2. Moto");
                    System.out.println("Elige una opcion: ");
                    opcionVehiculo = input.nextInt();
                    input.nextLine();

                    //Vehiculo nuevo;
                    System.out.println("Ingrese la marca: ");
                    marca = input.nextLine();
                    System.out.println("Ingrese el modelo: ");
                    modelo = input.nextLine();
                    System.out.println("Ingrese el precio: ");
                    precio =  input.nextDouble();
                    input.nextLine();

                    if(opcionVehiculo == 1){
                        Coche nuevo = new Coche(marca,modelo,precio);
                        listaConcesionaria.agregarVehiculo(nuevo);
                    }else if(opcionVehiculo == 2){
                        Moto nuevo = new Moto(marca,modelo,precio);
                        listaConcesionaria.agregarVehiculo(nuevo);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la marca del vehículo: ");
                    marca = input.nextLine();
                    System.out.println("Ingrese el modelo del vehículo: ");
                    modelo = input.nextLine();
                    System.out.println("Ingrese el nuevo precio: ");
                    double precioNuevo = input.nextDouble();
                    listaConcesionaria.editarPrecio(marca,modelo,precioNuevo);
                    break;
                case 3:
                    System.out.println("Ingrese la marca del vehículo a eliminar: ");
                    marca = input.nextLine();
                    System.out.println("Ingrese el modelo del vehículo a eliminar: ");
                    modelo = input.nextLine();

                    listaConcesionaria.eliminarVehiculo(marca,modelo);
                    break;
                case 4:
                    listaConcesionaria.mostrarInventario();
                    break;
                case 5:
                    listaConcesionaria.guardar(listaConcesionaria.getListaVehiculos());
                    break;
                case 6:
                    listaConcesionaria.setListaVehiculos(listaConcesionaria.cargar());
                    break;

                case  7:
                    break;

            }
        }

    }

    public static Vehiculo nuevoVehiculo(int variante){
        String marca;
        String modelo;
        double precio;
        Vehiculo nuevo;
        System.out.println("Ingrese la marca: ");
        marca = input.nextLine();
        System.out.println("Ingrese el modelo: ");
        modelo = input.nextLine();
        System.out.println("Ingrese el precio: ");
        precio =  input.nextDouble();

        if(variante == 1){
            nuevo = new Coche(marca,modelo,precio);
            return nuevo;
        }else if(variante == 2){
            nuevo = new Moto(marca,modelo,precio);
            return nuevo;
        }

        return  null;
    }
}
