package Parcial2;

import java.sql.*;
public class DBHelper {
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
