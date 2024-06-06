package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/laboratorio1";
    private static final String USER = "Joly_Admin";
    private static final String PASSWORD = "Kazuha3421-";


    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado al servidor");
        } catch ( SQLException e){
            System.err.println("Falló la conexión" + e.getMessage());
        }
        return connection;
    }
}
