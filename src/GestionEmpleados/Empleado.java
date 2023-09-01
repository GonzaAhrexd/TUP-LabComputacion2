package GestionEmpleados;

abstract public class Empleado implements Impuesto{
    private int id;
    private String nombre;
    private double sueldoBase;
    abstract double calcularSueldo();

    public Empleado(int id, String nombre, double sueldoBase) { //Constructor de la clase abstracta Empleado
        this.id = id;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public abstract String toString(); //Método abstracto toString
    @Override
    public double calcularImpuesto(){
        return this.calcularSueldo() * 0.21;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
