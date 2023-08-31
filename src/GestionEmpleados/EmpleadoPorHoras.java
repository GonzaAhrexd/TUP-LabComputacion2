package GestionEmpleados;

public class EmpleadoPorHoras extends Empleado  {

    int horasTrabajadas;

    public EmpleadoPorHoras(int id, String nombre, double sueldoBase, int horasTrabajadas) {
        super(id, nombre, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "EmpleadoPorHoras{" +

                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sueldoBase=" + sueldoBase +
                ", horasTrabajadas=" + horasTrabajadas + '}';
    }

    @Override
    double calcularSueldo() {
        return this.sueldoBase * horasTrabajadas;
    }
}
