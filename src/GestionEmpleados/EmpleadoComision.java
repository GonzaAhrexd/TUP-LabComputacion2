package GestionEmpleados;

public class EmpleadoComision extends Empleado {
    double ventasRealizadas;

    public EmpleadoComision(int id, String nombre, double sueldoBase, double ventasRealizadas) {
        super(id, nombre, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {
        return "EmpleadoComision{" +
                "ventasRealizadas=" + ventasRealizadas +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sueldoBase=" + sueldoBase +
                '}';
    }

    @Override
    double calcularSueldo() {
        return this.sueldoBase + ventasRealizadas;
    }
}
