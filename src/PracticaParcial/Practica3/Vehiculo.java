package PracticaParcial.Practica3;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(){

    }
    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    abstract double calcularImpuesto();
    abstract void mostrarInformacion();
}
