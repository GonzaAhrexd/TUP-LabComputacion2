package Parcial1.PracticaParcial.Practica2;

public abstract class Cuenta {
    protected int numeroCuenta;
    protected float saldo;
    abstract void depositar(float cantidad);
    abstract void  retirar(float cantidad);
    abstract void mostrarInformacion();


    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cuenta(int numeroCuenta, float saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
}
