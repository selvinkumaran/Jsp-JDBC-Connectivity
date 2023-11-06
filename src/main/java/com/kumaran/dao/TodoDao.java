package com.kumaran.dao;

import com.kumaran.db.DatabaseConnection;
import com.kumaran.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private final Connection connection;
    private final String SELECT_ALL = "SELECT id, item, user_Id FROM todo WHERE user_Id=?";
    private final String SELECT_TODO = "SELECT id, item, userId FROM todo WHERE id=?";
    private final String INSERT_TODO = "INSERT INTO todo (item, user_Id) VALUES (?, ?);";
    private final String DELETE_TODO = "delete from todo where id=?";
//UPDATE todo SET  delete_flag=true WHERE id=?

    public TodoDao() {
        connection=DatabaseConnection.jdbcConnection();
    }
    public List<Todo> selectAllTodos(int user_Id) {
        List<Todo> todos = new ArrayList<Todo>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ps.setInt(1, user_Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(Integer.parseInt(rs.getString("id")));
                todo.setTodo(rs.getString("item"));
                todo.setUserId(rs.getInt("user_Id"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public void addTodo(String item, int user_Id) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_TODO);
            ps.setString(1, item);
            ps.setInt(2, user_Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_TODO);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
