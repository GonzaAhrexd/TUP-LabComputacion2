package practicaParcialV2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

       // Date fecha = new Date(2023-1900, 2-1, 1);
       // Date fecha2 = new Date(2023-1900, 11-1, 28);

     //   Paciente nuevoPaciente = new Paciente("Pepe asd", 34 , "elpasdepe", fecha2);

       // hospital.agregarPaciente(nuevoPaciente);
       // hospital.listarPacientes();
      //  hospital.asignarDoctores("Doctor1", "Paciente1");

      // hospital.listarPacientesEntreFechas(fecha,fecha2);
        //hospital.eliminarPaciente("Pepe Argento");

       //hospital.listarReciente(1);
       //hospital.listarPacientesPorHistorial("Historial2");
       //hospital.edadPromedioPacientes();

        hospital.pacientesUltimoMes();
    }
    }


