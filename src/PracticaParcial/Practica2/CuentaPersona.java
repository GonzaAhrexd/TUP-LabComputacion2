package PracticaParcial.Practica2;

public class CuentaPersona extends Cuenta{
    private String nombre;
    private String apellido;


    public CuentaPersona(int numeroCuenta, float saldo, String nombre, String apellido) {
        super(numeroCuenta, saldo);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    void depositar(float cantidad) {
        this.saldo += cantidad;
    }

    @Override
    void retirar(float cantidad) {
        if(cantidad < this.saldo){
            this.saldo  -= cantidad;
        }else{
            System.out.println("No tiene saldo suficiente");
        }
    }

    public void mostrarInformacion(){
        System.out.println("Número de cuenta: "  + this.numeroCuenta);
        System.out.println("Nombre: "  + this.nombre);
        System.out.println("Apellido: "  + this.apellido);
        System.out.println("Saldo: " + this.saldo);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
