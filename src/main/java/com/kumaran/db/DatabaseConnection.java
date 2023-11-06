package com.kumaran.db;

import java.sql.*;

public class DatabaseConnection {
    private final static String url = "jdbc:mysql://localhost:3306/demo";
    private final static String username = "root";
    private final static String password = "root";

    public static Connection jdbcConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection successfully");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
