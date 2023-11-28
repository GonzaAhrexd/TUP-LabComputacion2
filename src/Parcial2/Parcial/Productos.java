package Parcial2;

import javax.sound.midi.MidiMessage;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Productos {

    public static void generarInforme(){
        ResultSet productos = DBHelper.ejecutarConsultaConResultado("SELECT * FROM productos");
        float total = 0;
        System.out.println("Informe de Productos en Stock: ");
        System.out.println("Producto \t\t\t\t\t Stock \t Precio\tTotal");
        System.out.println("------------------------------------------------------");
        try {
            while (productos.next()) {

                String nombreProducto = productos.getString("nombre");
                int stock = productos.getInt("stock");
                float precio = productos.getFloat("precio_por_unidad");
                float totalProducto = stock * precio;

                System.out.printf("%-30s %-5d %-5.2f %-20.2f\n", nombreProducto, stock, precio, totalProducto);

                total += totalProducto;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t Total: \t\t "+total);
    }

    public static Producto obtenerProducto(int productoID) {
        String consulta = "SELECT * FROM productos WHERE producto_id = " + productoID;

        ResultSet productoResultado = DBHelper.ejecutarConsultaConResultado(consulta);
        Producto productoObtener;
        try {
            while (productoResultado.next()) {
                int id = productoResultado.getInt("producto_id");
                String nombre = productoResultado.getString("nombre");
                float precioUnidad = productoResultado.getFloat("precio_por_unidad");
                int stock = productoResultado.getInt("stock");
                productoObtener = new Producto(id, nombre, precioUnidad, stock);
                return productoObtener;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Producto obtenerProductoMasVendido(){
        String consulta = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido FROM ventas GROUP BY producto_id ORDER BY total_vendido DESC LIMIT 1";
        ResultSet ProductoMasVendido = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            while(ProductoMasVendido.next()) {
                int idMasVendido = ProductoMasVendido.getInt("producto_id");
                return obtenerProducto(idMasVendido);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
        }
}
