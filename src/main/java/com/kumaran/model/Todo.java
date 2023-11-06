package com.kumaran.model;

public class Todo {
    private int id;
    private int userId;
    private String item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTodo() {
        return item;
    }

    public void setTodo(String todo) {
        this.item = todo;
    }
}