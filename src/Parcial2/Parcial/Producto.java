package Parcial2;

public class Producto {
    private int producto_id;
    private String nombre;
    private float precio_por_unidad;
    private int stock;

    public Producto(int producto_id, String nombre, float precio_por_unidad, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_por_unidad() {
        return precio_por_unidad;
    }

    public void setPrecio_por_unidad(float precio_por_unidad) {
        this.precio_por_unidad = precio_por_unidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "producto_id=" + producto_id +
                ", nombre='" + nombre + '\'' +
                ", precio_por_unidad=" + precio_por_unidad +
                ", stock=" + stock +
                '}';
    }
}
