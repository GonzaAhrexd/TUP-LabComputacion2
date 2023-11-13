package practicaParcialV2;

import java.sql.Date;

public class Paciente extends Persona {
    private String historialMedico;
    private Date fechaIngreso;
    private int Doctor;

    public Paciente( String nombre, int edad, String historialMedico, Date fechaIngreso) {
        super(nombre, edad);
        this.historialMedico = historialMedico;
        this.fechaIngreso = fechaIngreso;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getDoctor() {
        return Doctor;
    }

    public void setDoctor(int doctor) {
        Doctor = doctor;
    }
}
