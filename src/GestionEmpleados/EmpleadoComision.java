package GestionEmpleados;

public class EmpleadoComision extends Empleado {
    private double ventasRealizadas;

    public EmpleadoComision(int id, String nombre, double sueldoBase, double ventasRealizadas) {
        super(id, nombre, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {
        return "EmpleadoComision{" +
                "id=" + this.getId()+
                ", nombre='" + this.getNombre() + '\'' +
                ", sueldoBase=" + this.getSueldoBase ()+
                ", ventasRealizadas = " + this.getVentasRealizadas() + '}';
    }

    @Override
    double calcularSueldo() {
        return this.getSueldoBase() + this.getVentasRealizadas();
    }
}
