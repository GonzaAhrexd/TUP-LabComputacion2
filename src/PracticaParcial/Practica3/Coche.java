package PracticaParcial.Practica3;

public class Coche extends Vehiculo implements java.io.Serializable{


    public Coche(String marca, String modelo, double precio) {
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
