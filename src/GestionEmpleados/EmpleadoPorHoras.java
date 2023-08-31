package GestionEmpleados;

public class EmpleadoPorHoras extends Empleado  {
    private int horasTrabajadas;
    public EmpleadoPorHoras(int id, String nombre, double sueldoBase, int horasTrabajadas) {
        super(id, nombre, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "EmpleadoPorHoras{" +

                "id=" + this.getId() +
                ", nombre='" + this.getNombre() + '\'' +
                ", sueldoBase=" + this.getSueldoBase() +
                ", horasTrabajadas=" +  + this.getHorasTrabajadas();
    }

    @Override
    double calcularSueldo() {
        return this.getSueldoBase() * this.getHorasTrabajadas();
    }
}
