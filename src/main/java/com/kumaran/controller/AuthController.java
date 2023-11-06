package com.kumaran.controller;

import com.kumaran.dao.UserDao;
import com.kumaran.db.DatabaseConnection;
import com.kumaran.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthController extends HttpServlet {
    private final UserDao userDao;

    public AuthController() {
        userDao = new UserDao();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User loggedInUser = UserDao.loginUser(email, password);
        if (loggedInUser != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("id", loggedInUser.getId());
            RequestDispatcher rd = req.getRequestDispatcher("todo.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("error", true);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        }
    }
}
