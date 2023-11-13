package practicaParcialV2;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class DBHelper {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String usuario = "root";
    private static final String pass = "";
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, usuario, pass);
            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Operación realizada exitosamente.");
                } else {
                    System.out.println("No se pudo realizar la operación.");
                }
            }
            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static ResultSet ejecutarConsultaConResultado(String consulta) {
            try {
                // Establecer la conexión con la base de datos
                Connection connection = DriverManager.getConnection(url, usuario, pass);
                PreparedStatement statement = connection.prepareStatement(consulta);
                    return statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

    }
}
