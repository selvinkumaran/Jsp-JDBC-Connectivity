package com.kumaran.controller;

import com.kumaran.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private final UserDao userDao;

    public RegisterController() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name, email, password, c_password;
        name = req.getParameter("name");
        email = req.getParameter("email");
        password = req.getParameter("password");
        c_password = req.getParameter("Confirm-password");

        if (password.equals(c_password)) {
            if (userDao.registerUser(name, email, password)) {
                System.out.println("Registration successful.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);

            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
                dispatcher.forward(req, resp);            }
        } else {
            System.out.println("Password Mismatch.");
        }
    }
}
