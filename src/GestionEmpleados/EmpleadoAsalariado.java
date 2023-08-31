package GestionEmpleados;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(int id, String nombre, double sueldoBase) {
        super(id, nombre, sueldoBase);
    }

    @Override
    public String toString() {
        return "EmpleadoAsalariado{" +
                "id=" + this.getId() +
                ", nombre='" + this.getNombre() + '\'' +
                ", sueldoBase=" + this.getSueldoBase() +
                '}';
    }

    @Override
    double calcularSueldo() {
        return this.getSueldoBase();
    }
}
