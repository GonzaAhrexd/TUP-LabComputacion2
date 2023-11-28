package Parcial2.Parcial.ParcialUnificado;

import java.sql.*;
import java.util.ArrayList;


    //Clase DBHelper
     class DBHelper {
        private static final String url = "jdbc:mysql://localhost:3306/ventas";
        private static final String usuario = "root";
        private static final String pass = "";
        public static void ejecutarConsulta(String consulta) {
            try {
                Connection connection = DriverManager.getConnection(url, usuario, pass);
                try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("La operación fue realizada exitosamente.");
                    } else {
                        System.out.println("No se pudo realizar la operación.");
                    }
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static ResultSet ejecutarConsultaConResultado(String consulta) {
            try {
                Connection connection = DriverManager.getConnection(url, usuario, pass);
                PreparedStatement statement = connection.prepareStatement(consulta);
                return statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
    }
    //Clase producto
     class Producto {
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
    //Clase vendedor
     class Vendedor {
        private int vendedor_id;
        private String nombre;
        private String apellido;
        private String dni;
        private Date fecha_nacimiento;
        private Date fecha_contratacion;

        public Vendedor(String nombre, String apellido, String dni, Date fecha_nacimiento, Date fecha_contratacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.fecha_nacimiento = fecha_nacimiento;
            this.fecha_contratacion = fecha_contratacion;
        }

        public Vendedor(String consulta) {
            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
            try {
                while (resultado.next()) {
                    this.vendedor_id = resultado.getInt("vendedor_id");
                    this.nombre = resultado.getString("nombre");
                    this.apellido = resultado.getString("apellido");
                    this.dni = resultado.getString("dni");
                    this.fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                    this.fecha_contratacion = resultado.getDate("fecha_contratacion");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public int getVendedor_id() {
            return vendedor_id;
        }

        public void setVendedor_id(int vendedor_id) {
            this.vendedor_id = vendedor_id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public Date getFecha_nacimiento() {
            return fecha_nacimiento;
        }

        public void setFecha_nacimiento(Date fecha_nacimiento) {
            this.fecha_nacimiento = fecha_nacimiento;
        }

        public Date getFecha_contratacion() {
            return fecha_contratacion;
        }

        public void setFecha_contratacion(Date fecha_contratacion) {
            this.fecha_contratacion = fecha_contratacion;
        }

        @Override
        public String toString() {
            return "Vendedor{" +
                    "vendedor_id=" + vendedor_id +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", dni='" + dni + '\'' +
                    ", fecha_nacimiento=" + fecha_nacimiento +
                    ", fecha_contratacion=" + fecha_contratacion +
                    '}';
        }
    }
    //Comerciales
     class Comerciales {

        public static Vendedor obtenerVendedorPorID(int vendedorID){
            String consulta = "SELECT * FROM vendedores WHERE vendedor_id = "+vendedorID;
            Vendedor vendedorAObtener = new Vendedor(consulta);
            if(vendedorAObtener!=null) {
                return vendedorAObtener;
            }
            return null;
        }

        public static ArrayList<Vendedor> listadoDeVendedores(){
            ArrayList<Vendedor> nuevaListaVendedores = new ArrayList<Vendedor>();

            String consulta = "SELECT * FROM vendedores";
            ResultSet obtenerVendedores = DBHelper.ejecutarConsultaConResultado(consulta);

            try{
                while (obtenerVendedores.next()){
                    int idActual = obtenerVendedores.getInt("vendedor_id");
                    Vendedor agregarVendedor = Comerciales.obtenerVendedorPorID(idActual);
                    nuevaListaVendedores.add(agregarVendedor);
                }
                return nuevaListaVendedores;
            }catch(SQLException e){
                e.printStackTrace();
            }
            return null;
        }


    }
    //clase Productos
    class Productos {

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
public class SistemaDeVentas {
        public static void main(String[] args) {
            //3. Creación de un Constructor Adicional en la clase Vendedor (0,5 p.) FUNCIONA

/*
        Vendedor vendedorNuevo = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");
        System.out.println(vendedorNuevo.toString());
*/
            //4. Obtener los datos de un Vendedor (1,5 p.) FUNCIONA
/*
        Vendedor vendedor3 = Comerciales.obtenerVendedorPorID(3);
        System.out.println(vendedor3.getNombre());
*/
            //5. Generación de Informe de Productos en Stock (2 p.) FUNCIONA
            //Productos.generarInforme();

            //6. Obtener Producto por ID (1 p.) FUNCIONA
        /*
        Producto nuevoProducto = Productos.obtenerProducto(5);
        System.out.println(nuevoProducto.toString());
        */
            //7. Obtener el Producto Más Vendido (2 p.) FUNCIONA
            // System.out.println(Productos.obtenerProductoMasVendido().toString());

            //8. Obtener el Listado de Vendedores (2 p.) FUNCIONA
        /*ArrayList<Vendedor> listaVendedores = Comerciales.listadoDeVendedores();

        for (Vendedor cadaVendedor : listaVendedores) {
            System.out.println(cadaVendedor.toString());
        }*/

        }
    }


