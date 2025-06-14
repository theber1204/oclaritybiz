package com.oclaritybiz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/oclaritybiz_bd";
    private static final String DB_USER = "theber";
    private static final String DB_PASSWORD = "theber_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}