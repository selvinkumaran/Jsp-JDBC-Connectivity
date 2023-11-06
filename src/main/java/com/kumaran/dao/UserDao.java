package com.kumaran.dao;

import com.kumaran.db.DatabaseConnection;
import com.kumaran.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static Connection connection = null;

    public UserDao() {
        connection =DatabaseConnection.jdbcConnection();
    }
    private static String getUserDb = "SELECT id, email, password FROM user WHERE email=? and password=?";
    private final static String sqlRegister = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

    public static User loginUser(String email, String password) {
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(getUserDb);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public boolean registerUser(String name, String email, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRegister);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
