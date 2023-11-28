package Parcial1.PracticaParcial.Practica3;

public class Moto extends Vehiculo implements java.io.Serializable{


    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    double calcularImpuesto() {
        return this.getPrecio()  * 0.21;
    }

    @Override
    void mostrarInformacion() {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Módelo: " + this.getModelo());
        System.out.println("Precio: " + this.getPrecio());
    }

}
