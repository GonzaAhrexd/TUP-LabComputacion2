package PracticaParcial.Practica3;
import java.io.*;
import java.util.ArrayList;

public class Concesionaria implements Serializable{
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();


    public ArrayList<Vehiculo> getListaVehiculos() {
        return this.listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        this.listaVehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(String marca, String modelo){
        int indice = obtenerIndiceVehiculo(marca,modelo);
        try{
            this.listaVehiculos.remove(indice);
        }catch(IndexOutOfBoundsException e){
            System.out.println("El modelo y marca ingresados no existe");
        }
    }

    public void editarPrecio(String marca, String modelo, double nuevoPrecio){
        int indice = obtenerIndiceVehiculo(marca,modelo);

        this.listaVehiculos.get(indice).setPrecio(nuevoPrecio);
    }

    public void mostrarInventario(){
        System.out.println("Vehículo \t Marca \t  Modelo \t Precio  ");
        for (Vehiculo actual: listaVehiculos) {
            System.out.println(actual.getClass().getSimpleName() + "\t" + actual.getMarca() +  "\t" + actual.getModelo() +  "\t" + actual.getPrecio());
        }
    }
    private int obtenerIndiceVehiculo(String marca, String modelo){
        int i =0;
        for (Vehiculo actual: listaVehiculos ) {
            if(actual.getMarca().equals(marca) && actual.getModelo().equals(modelo)){
                return i;
            }
            i++;
        }
        return -1;
    }



    @Override
    public void guardar(ArrayList<Vehiculo> listaVehiculos){
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\PracticaParcial\\Practica3\\ListaVehiculos");
            ObjectOutputStream fluxOut = new ObjectOutputStream(fileOut);
            fluxOut.writeObject(listaVehiculos);
            fluxOut.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Vehiculo> cargar(){
        ArrayList<Vehiculo> listaVehiculo;
        try{
            FileInputStream fileIn = new FileInputStream("src\\PracticaParcial\\Practica3\\ListaVehiculos");
            ObjectInputStream fluxIn = new ObjectInputStream(fileIn);
            listaVehiculo = (ArrayList<Vehiculo>) fluxIn.readObject();
            fluxIn.close();
            return listaVehiculo;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }



}
