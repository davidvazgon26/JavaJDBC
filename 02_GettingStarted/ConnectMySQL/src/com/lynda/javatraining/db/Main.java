package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "Qwerty78.";
    private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws  SQLException {

        // Class.forName("com.mysql.jdbc.Driver");  //Para versiones posteriores a Java 7

        Connection conn = null; //Siempore seleccionar la opcion java.sql para hacerlo mas portable.

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
    }

}
