package GestionEmpleados;

abstract public class Empleado implements Impuesto{
    protected int id;
    protected String nombre;
    protected double sueldoBase;
    abstract double calcularSueldo();

    public Empleado(int id, String nombre, double sueldoBase) {
        this.id = id;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public abstract String toString();
    @Override
    public double calcularImpuesto(){
        return this.calcularSueldo() * 0.21;
    }

}
