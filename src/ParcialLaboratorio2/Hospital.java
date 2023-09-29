
package ParcialLaboratorio2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        GestionHospital gestionHospital = new GestionHospital(true);

        int caracter;
        char letra = ' ';
        String datosDeContacto = "";
        try {
            FileReader entrada = new FileReader("src" + File.separator + "ParcialLaboratorio2" + File.separator + "datos.txt" );

            caracter =  entrada.read();
            letra = (char)caracter;

            while(caracter != -1){
                datosDeContacto  += letra;
                caracter = entrada.read();
                letra = (char)caracter;
            }
            entrada.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("Hospital Julio C. Perrando - " + datosDeContacto);
            System.out.println("Menú: ");
            System.out.println("1. Listar doctores ");
            System.out.println("2. Registrar un nuevo paciente ");
            System.out.println("3. Actualizar información personal de un paciente ");
            System.out.println("4. Consultar el historial para un paciente ");
            System.out.println("5. Nuevo historial para un paciente ");
            System.out.println("6. Guardar historial para un paciente en archivo ");
            System.out.println("7. Cargar Historial de pacientes desde archivo");
            System.out.println("8. Salir");


            System.out.println("Ingrese su opción: ");
            opcion = input.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Lista de doctores: ");
                    gestionHospital.listarDoctores();
                    break;
                case 2:
                    System.out.println("Registro de un nuevo paciente: ");
                    gestionHospital.registrarPacientes();
                    break;
                case 3:
                    System.out.println("Actualizar información personal de un paciente");
                    gestionHospital.editarPacientes();
                    break;
                case 4:
                    System.out.println("Consultar historial para un paciente");
                    gestionHospital.consultarHistorialMedico();
                    break;
                case 5:
                    System.out.println("Nuevo historial para un paciente");
                    gestionHospital.nuevoHistorialMedico();
                    break;
                case 6:
                    System.out.println("Guardar historial para un paciente en archivo ");
                    gestionHospital.guardarPacientes(gestionHospital.getListaPacientes());
                    break;
                case 7:
                    System.out.println(" Cargar Historial de pacientes desde archivo");
                    gestionHospital.setListaPacientes(gestionHospital.cargar());
                    break;
                case 8:
                    break;
            }
        }

    }
}


abstract class Persona implements java.io.Serializable{
    private String nombre;
    private int DNI;
    private String fechaNacimiento;

    public Persona(){

    }
    public Persona(String nombre, int DNI, String fechaNacimiento) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

class Doctor extends Persona{
    private String Especialidad;

    public Doctor(String nombre, int DNI, String fechaNacimiento, String especialidad) {
        super(nombre, DNI, fechaNacimiento);
        Especialidad = especialidad;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
}


class Historial implements java.io.Serializable{
    private String fecha;
    private String observaciones;

    public Historial(){

    }
    public Historial(String fecha, String observaciones) {
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

interface Informacion {
    void verHistorialDeEventos();
}


class Paciente extends Persona implements Informacion, java.io.Serializable{
    private long nroTelefono;
    private int tipoSangre;
    private ArrayList<Historial> historialMedico = new ArrayList<Historial>();

    public Paciente() {

    }


    public Paciente(String nombre, int DNI, String fechaNacimiento, long nroTelefono, int tipoSangre) {
        super(nombre, DNI, fechaNacimiento);
        this.nroTelefono = nroTelefono;
        this.tipoSangre = tipoSangre;
    }

    public long getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(long nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public ArrayList<Historial> getHistorialMedico() {
        return historialMedico;
    }
    public void getHistorialMedico(ArrayList<Historial> historialMedico){
        this.historialMedico = historialMedico;
    }
    public void addHistorialMedico(Historial historialMedico) {
        this.historialMedico.add(historialMedico);
    }

    @Override
    public void verHistorialDeEventos() {
        System.out.println("HISTORIAL MÉDICO");
        for (Historial historial: this.historialMedico) {
            System.out.println(historial.getFecha() + "-" + historial.getObservaciones());
        }
    }
}



 class GestionHospital implements java.io.Serializable {
    public static Scanner input = new Scanner(System.in);
    private ArrayList<Doctor> listaDoctores = new ArrayList<Doctor>();
    private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
    Doctor doctor1 = new Doctor("Pablo",2339424,"20/05/1990", "Traumatologo");
    Doctor doctor2 = new Doctor("Carlos",2335424,"03/01/1990", "Dentista");
    Doctor doctor3 = new Doctor("Roberto",2239424,"15/05/1980", "Pediatra");
    Doctor doctor4 = new Doctor("Damian",2339464,"20/04/1990", "Dentista");
    Doctor doctor5 = new Doctor("Pedro",2334244,"14/01/1972", "Traumatologo");

    public GestionHospital() {

    }

    public GestionHospital(boolean inciarDoctores) {
        listaDoctores.add(doctor1);
        listaDoctores.add(doctor2);
        listaDoctores.add(doctor3);
        listaDoctores.add(doctor4);
        listaDoctores.add(doctor5);
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void listarDoctores(){
        System.out.println("Nombre \t DNI \t Fecha de Nacimiento \t Especialidad");
        String huespedes = "";
        for (Doctor doctor: listaDoctores) {
            System.out.println(doctor.getNombre() + "\t" + doctor.getDNI()  + "\t\t" + doctor.getFechaNacimiento()  + "\t\t\t" + doctor.getEspecialidad());
        }

    }



    public void registrarPacientes(){
        String nombre, fechaNacimiento;
        int dni, tipoSangre;
        long nroTelefono;
        System.out.println("Nuevo paciente: ");
        System.out.println("Ingrese el DNI del nuevo paciente a registrar: ");
        dni = input.nextInt();
        input.nextLine();
        System.out.println("Ingrese el nombre del nuevo paciente a registrar: ");
        nombre = input.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del nuevo paciente a registrar: ");
        fechaNacimiento = input.nextLine();

        System.out.println("Ingrese el número de teléfono del nuevo paciente a registrar: ");
        nroTelefono = input.nextLong();

        System.out.println("Ingrese el tipo de sangre del nuevo paciente a registrar: ");
        tipoSangre = input.nextInt();

        input.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre,dni,fechaNacimiento,nroTelefono,tipoSangre);
        listaPacientes.add(nuevoPaciente);
    }
    public void editarPacientes(){
        String nombre, fechaNacimiento;
        int dni, tipoSangre;
        long nroTelefono;
        int indice;
        System.out.println("Ingrese el DNI del paciente a editar: ");
        dni = input.nextInt();
        input.nextLine();
        if(obtenerIndice(dni) != -1) {
            indice = obtenerIndice(dni);
            System.out.println("Ingrese el nombre del nuevo paciente a editar: ");
            nombre = input.nextLine();
            this.listaPacientes.get(indice).setNombre(nombre);

            System.out.println("Ingrese la fecha de nacimiento del paciente a editar: ");
            fechaNacimiento = input.nextLine();
            this.listaPacientes.get(indice).setFechaNacimiento(fechaNacimiento);

            System.out.println("Ingrese el número de teléfono del paciente a editar ");
            nroTelefono = input.nextLong();
            this.listaPacientes.get(indice).setNroTelefono(nroTelefono);

            System.out.println("Ingrese el tipo de sangre del paciente a editar: ");
            tipoSangre = input.nextInt();
            this.listaPacientes.get(indice).setTipoSangre(tipoSangre);
        }else{
            System.out.println("El dni del paciente no existe");
        }
    }
    public void nuevoHistorialMedico(){
        int dni, indice;
        String fecha, texto;
        System.out.println("Ingrese el DNI del paciente a editar: ");
        dni = input.nextInt();
        Historial historial;
        input.nextLine();
        if(obtenerIndice(dni) != -1) {
            indice = obtenerIndice(dni);
            System.out.println("Ingrese la fecha del nuevo registro: ");
            fecha = input.nextLine();
            System.out.println("Ingrese la información del nuevo registro: ");
            texto = input.nextLine();
            historial = new Historial(fecha,texto);

            this.listaPacientes.get(indice).addHistorialMedico(historial);
        }
    }
    public void consultarHistorialMedico(){
        int dni;
        System.out.println("Ingrese el DNI del paciente a consultar: ");
        dni = input.nextInt();
        input.nextLine();
        int indice = obtenerIndice(dni);
        if(obtenerIndice(dni) != -1) {
            System.out.println("HISTORIAL MÉDICO: ");
            for (Historial historial : this.listaPacientes.get(indice).getHistorialMedico()) {
                System.out.println(historial.getFecha() + " - " + historial.getObservaciones());
            }
        }
    }
        private int obtenerIndice(int dni){
        int indice = -1;
        int i = 0;
            for (Paciente paciente: this.listaPacientes) {
              if(dni == paciente.getDNI()){
                  return i;
              }
                i++;
            }
        return indice;
    }
    
     public void guardarPacientes(ArrayList<Paciente> listaPacientes){
             try {
                 FileOutputStream fileOut = new FileOutputStream("src" + File.separator + "ParcialLaboratorio2" + File.separator + "InfoPacientes.dat");
                 ObjectOutputStream fluxOut = new ObjectOutputStream(fileOut);
                 fluxOut.writeObject(listaPacientes);
                 fluxOut.close();
                 System.out.println("Se ha guardado con éxito!");
             }catch (IOException e){
                 e.printStackTrace();
             }
         }
          public ArrayList<Paciente> cargar(){
                  ArrayList<Paciente> listaPaciente;
                  try{
                      FileInputStream fileIn = new FileInputStream("src" + File.separator + "ParcialLaboratorio2" + File.separator + "InfoPacientes.dat");
                      ObjectInputStream fluxIn = new ObjectInputStream(fileIn);
                      listaPaciente = (ArrayList<Paciente>) fluxIn.readObject();
                      fluxIn.close();
                      return listaPaciente;
                  }catch(Exception e){
                      e.printStackTrace();
                      return null;
                  }

              }
}



