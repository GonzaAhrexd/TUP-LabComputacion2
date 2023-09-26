package PracticaParcial.Practica2;

import java.util.ArrayList;

public class GestorCuenta {
     ArrayList<CuentaPersona> listaCuentaPersona= new ArrayList<CuentaPersona>();
    ArrayList<CuentaSociedad> listaCuentaSociedad= new ArrayList<CuentaSociedad>();

    public void agregarCuentaPersona(CuentaPersona cuenta){
        this.listaCuentaPersona.add(cuenta);
    }
    public void agregarCuentaSociedad(CuentaSociedad cuenta){
        this.listaCuentaSociedad.add(cuenta);
    }

    public void eliminarCuentaPersona(int numeroCuenta){

        int indice = obtenerIndicePersona(numeroCuenta);

        if(indice != -1){
            this.listaCuentaPersona.remove(indice);
        }else{
            System.out.println("No existe el numero de cuenta");
        }


    }

    public void eliminarCuentaSociedad(int numeroCuenta){
        int indice = obtenerIndiceSociedad(numeroCuenta);

        if(indice != -1){
            this.listaCuentaSociedad.remove(indice);
        }else{
            System.out.println("No existe el numero de cuenta");
        }
    }

    public void editarCuentaSociedad(int numeroCuenta, float nuevoSaldo){
        int indice = obtenerIndiceSociedad(numeroCuenta);
       CuentaSociedad remplazo;

        if(indice != -1){
            remplazo = new CuentaSociedad(numeroCuenta, nuevoSaldo, this.listaCuentaSociedad.get(indice).getNombreEmpresa(), this.listaCuentaSociedad.get(indice).getTipoEmpresa() );
           this.listaCuentaSociedad.set(indice, remplazo);
       }else{
            System.out.println("No existe el numero de cuenta");
        }
    }

    public void editarCuentaPersona(int numeroCuenta, float nuevoSaldo){
        int indice = obtenerIndicePersona(numeroCuenta);
        CuentaPersona remplazo;

        if(indice != -1){
            remplazo  = new CuentaPersona(numeroCuenta, nuevoSaldo, this.listaCuentaPersona.get(indice).getNombre(), this.listaCuentaPersona.get(indice).getApellido());
            this.listaCuentaPersona.set(indice, remplazo);
        }else{
            System.out.println("No existe el numero de cuenta");
        }
    }

    private int obtenerIndiceSociedad(int numeroCuenta){
        int i =0;
        for (CuentaSociedad actual: listaCuentaSociedad ) {
            if(actual.getNumeroCuenta()  == numeroCuenta){
                return i;
            }
            i++;
        }
        return -1;
    }

    private int obtenerIndicePersona(int numeroCuenta){
        int i =0;
        for (CuentaPersona actual: listaCuentaPersona ) {
            if(actual.getNumeroCuenta()  == numeroCuenta){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void mostrarTodasLasCuentas(){
        System.out.println("Cuentas de persona: ");
        for(CuentaPersona cuenta : this.listaCuentaPersona){
            System.out.println("Cuenta \tNombre Apellido \tSaldo actual" );
            System.out.println(cuenta.getNumeroCuenta() + "\t" + cuenta.getNombre() + "\t" + cuenta.getApellido() + "\t \t" + cuenta.getSaldo());

        }
        System.out.println("Cuentas de sociedad ");
        for(CuentaSociedad cuenta : this.listaCuentaSociedad){
            System.out.println("Cuenta \t Nombre de la empresa \tTipo de empresa \tSaldo actual" );
            System.out.println(cuenta.getNumeroCuenta() + "\t " + cuenta.getNombreEmpresa() + "\t \t \t" + cuenta.getTipoEmpresa() + "\t \t " + cuenta.getSaldo());
        }
    }

}
