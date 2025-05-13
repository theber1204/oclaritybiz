package com.oclaritybiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL, usuario y contraseña de la base de datos
    // Asegúrate de que el nombre de la base de datos sea el correcto: "oclaritybiz_bd"
    private static final String DB_URL = "jdbc:mysql://localhost:3306/oclaritybiz_bd";
    private static final String DB_USER = "root";       // Cambia este valor si usas otro usuario
    private static final String DB_PASS = "";  // Sustituye por la contraseña real

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    // Método de prueba para verificar la conexión
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}