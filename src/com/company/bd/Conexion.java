package com.company.bd;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexion {
        private static String url = "jdbc:mysql://localhost/clinica";
        private static String usuario = "clinica";
        private static String pass = "123456";
        private static Connection conexion;

        public static Connection getConexion() {
            if (conexion == null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    conexion = DriverManager.getConnection(url, usuario, pass);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return conexion;
        }
    }

