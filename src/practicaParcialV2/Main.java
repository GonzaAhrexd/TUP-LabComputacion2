package practicaParcialV2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Date fecha = new Date(2010-1900, 2-1, 27);
        Date fecha2 = new Date(2015-1900, 3-1, 28);

        Paciente nuevoPaciente = new Paciente("Pepe Argento", 48 , "elpepe", fecha);

        // hospital.agregarPaciente(nuevoPaciente);
       // hospital.listarPacientes();
       // hospital.asignarDoctores("Doctor1", "Paciente1");

      // hospital.listarPacientesEntreFechas(fecha,fecha2);
        hospital.eliminarPaciente("Pepe Argento");
    }
    }


