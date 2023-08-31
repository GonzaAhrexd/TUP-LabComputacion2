package GestionEmpleados;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(int id, String nombre, double sueldoBase) {
        super(id, nombre, sueldoBase);
    }

    @Override
    public String toString() {
        return "EmpleadoAsalariado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sueldoBase=" + sueldoBase +
                '}';
    }

    @Override
    double calcularSueldo() {
        return sueldoBase;
    }
}
