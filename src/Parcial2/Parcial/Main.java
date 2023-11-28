package Parcial2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //3. Creación de un Constructor Adicional en la clase Vendedor (0,5 p.)

        /*
        Vendedor vendedorNuevo = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");
        System.out.println(vendedorNuevo.toString());
         */
        //4. Obtener los datos de un Vendedor (1,5 p.)
        /*
        Vendedor vendedor3 = Comerciales.obtenerVendedorPorID(3);
        System.out.println(vendedor3.getNombre());
*/
        //5. Generación de Informe de Productos en Stock (2 p.)
        //Productos.generarInforme();

        //6. Obtener Producto por ID (1 p.)
        /*
        Producto nuevoProducto = Productos.obtenerProducto(5);
        System.out.println(nuevoProducto.toString());
        */
        //7. Obtener el Producto Más Vendido (2 p.)
       // System.out.println(Productos.obtenerProductoMasVendido().toString());

        //8. Obtener el Listado de Vendedores (2 p.)
        /*ArrayList<Vendedor> listaVendedores = Comerciales.listadoDeVendedores();

        for (Vendedor cadaVendedor : listaVendedores) {
            System.out.println(cadaVendedor.toString());
        }*/

    }
}