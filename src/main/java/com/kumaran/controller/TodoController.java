package com.kumaran.controller;

import com.kumaran.dao.TodoDao;
import com.kumaran.model.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TodoController extends HttpServlet {
    private final TodoDao todoDao;

    public TodoController() {
        todoDao = new TodoDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            todoDao.deleteTodo(Integer.parseInt(id));
        }

        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo.jsp");
        String user_Id = req.getSession().getAttribute("id").toString();

        String item = req.getParameter("todo");

        if (item != null && !item.trim().isEmpty())
            todoDao.addTodo(item, Integer.parseInt(user_Id));

        List<Todo> todos = todoDao.selectAllTodos(Integer.parseInt(user_Id));
        req.setAttribute("todos", todos);
        dispatcher.forward(req, resp);

    }

}
