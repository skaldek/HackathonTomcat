package com.hack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hack.dao.UserDao;
import com.hack.models.User;

import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = req.getParameter("username").toString();
        String password = req.getParameter("password").toString();
        PrintWriter writer = resp.getWriter();
        User user = userDao.find(username);
        if(user.getPassword().equals(password)) writer.println("ok");

    }

}
