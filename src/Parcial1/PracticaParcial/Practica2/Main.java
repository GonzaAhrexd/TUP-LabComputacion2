package Parcial1.PracticaParcial.Practica2;
import java.util.Scanner;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        GestorCuenta gestor = new GestorCuenta();
        int opcion = 0;
        int opcionCuenta;
        int numeroCuenta;
        while(true){
            System.out.println("1. Agregar cuenta ");
            System.out.println("2. Editar cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Mostrar cuentas");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = input.nextInt();


            switch (opcion){
                case 1:
                    System.out.println("1. Cuenta de Persona");
                    System.out.println("2. Cuenta de Sociedad");
                    opcionCuenta = input.nextInt();
                    switch (opcionCuenta){
                        case 1:
                            CuentaPersona cuentaPersona = generarCuentaPersona();
                            gestor.agregarCuentaPersona(cuentaPersona);
                            break;
                        case 2:
                            CuentaSociedad cuentaSociedad = generarCuentaSociedad();
                            gestor.agregarCuentaSociedad(cuentaSociedad);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Cuenta de Persona");
                    System.out.println("2. Cuenta de Sociedad");
                    opcionCuenta = input.nextInt();
                    float saldoNuevo;

                    switch (opcionCuenta){
                        case 1:
                            System.out.println("Ingrese el número de la cuenta a editar: ");
                            numeroCuenta = input.nextInt();
                            System.out.printf("Ingrese el nuevo  saldo a modificar: ");
                            saldoNuevo  =  input.nextFloat();
                            gestor.editarCuentaPersona(numeroCuenta, saldoNuevo);
                            break;
                        case 2:
                            System.out.println("Ingrese el número de la cuenta a editar: ");
                            numeroCuenta = input.nextInt();
                            System.out.printf("Ingrese el nuevo  saldo a modificar: ");
                            saldoNuevo  =  input.nextFloat();
                            gestor.editarCuentaSociedad(numeroCuenta, saldoNuevo);
                            break;

                    }
                    break;
                case 3:
                    System.out.println("1. Cuenta de Persona");
                    System.out.println("2. Cuenta de Sociedad");
                    opcionCuenta = input.nextInt();
                    switch (opcionCuenta){
                        case 1:
                            System.out.println("Ingrese el número de la cuenta a eliminar: ");
                            numeroCuenta = input.nextInt();
                            gestor.eliminarCuentaPersona(numeroCuenta);
                            break;
                        case 2:
                            System.out.println("Ingrese el número de la cuenta a eliminar: ");
                            numeroCuenta = input.nextInt();
                            gestor.eliminarCuentaSociedad(numeroCuenta);
                            break;

                    }
                case 4:
                   gestor.mostrarTodasLasCuentas();
                    break;
                case 5:
                    break;
            }




        }
    }

    public static CuentaPersona generarCuentaPersona(){
        int numeroCuenta;
        float saldo;
        String nombre;
        String apellidoOTipo;

                System.out.println("Ingrese el  número de la cuenta: ");
                numeroCuenta = input.nextInt();
                System.out.println("Ingrese el saldo de la cuenta: ");
                saldo = input.nextFloat();
                input.nextLine();
                System.out.println("Ingrese el nombre del titular: ");
                nombre = input.nextLine();
                System.out.println("Ingrese el apellido del titular: ");
                apellidoOTipo = input.nextLine();

                CuentaPersona cuentaPersona = new CuentaPersona(numeroCuenta, saldo, nombre, apellidoOTipo);
                return cuentaPersona;




    }

    public static CuentaSociedad generarCuentaSociedad(){
        int numeroCuenta;
        float saldo;
        String nombre;
        String tipo;

        System.out.println("Ingrese el  número de la cuenta: ");
        numeroCuenta = input.nextInt();
        System.out.println("Ingrese el saldo de la cuenta: ");
        saldo = input.nextFloat();
        input.nextLine();
        System.out.println("Ingrese el nombre de la empresa: ");
        nombre = input.nextLine();
        System.out.println("Ingrese el tipo de empresa: ");
        tipo = input.nextLine();

        CuentaSociedad cuentaSociedad = new CuentaSociedad(numeroCuenta, saldo, nombre, tipo);
        return cuentaSociedad;
    }
}
