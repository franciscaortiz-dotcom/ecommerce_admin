package com.insumos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    
    private static final String URL = "jdbc:postgresql://localhost:5432/ecommerce_admin";
    private static final String USER = "postgres";
    private static final String PASS = "Postgrefran";

    public static Connection getConnection() {
        Connection con = null;
        try {
           
            Class.forName("org.postgresql.Driver");
            
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}


