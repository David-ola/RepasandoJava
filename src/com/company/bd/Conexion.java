package com.company.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url="jdbc:mysql://localhost/clinica";
    private static String usr="clinica";
    private static String pass="1234";
    private static Connection conn;

    public static Connection getConn() {
        if(conn==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // Establecemos la conexión con la base de datos.
            try {
                conn = DriverManager.getConnection (url,usr,pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}

