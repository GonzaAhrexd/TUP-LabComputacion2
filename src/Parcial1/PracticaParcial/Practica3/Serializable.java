package Parcial1.PracticaParcial.Practica3;

import java.util.ArrayList;

public interface Serializable {
    public void guardar(ArrayList<Vehiculo> listaVehiculos);
    public ArrayList<Vehiculo>  cargar();
}
