package Parcial2;

import java.sql.*;

public class Vendedor {
    private int vendedor_id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;

    public Vendedor(String nombre, String apellido, String dni, Date fecha_nacimiento, Date fecha_contratacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
    }

    public Vendedor(String consulta){
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            while (resultado.next()) {
                this.vendedor_id = resultado.getInt("vendedor_id");
                this.nombre = resultado.getString("nombre");
                this.apellido = resultado.getString("apellido");
                this.dni = resultado.getString("dni");
                this.fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                this.fecha_contratacion = resultado.getDate("fecha_contratacion");

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendedor_id=" + vendedor_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_contratacion=" + fecha_contratacion +
                '}';
    }
}
