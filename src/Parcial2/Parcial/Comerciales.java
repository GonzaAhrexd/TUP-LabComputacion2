package Parcial2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Comerciales {

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
