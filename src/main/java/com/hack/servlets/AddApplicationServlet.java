package com.hack.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hack.dao.ApplicationDao;
import com.hack.models.Application;

@WebServlet("/add_application")
public class AddApplicationServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationDao applicationDao = new ApplicationDao();
        String userId = req.getParameter("userId");
        String description = req.getParameter("description");
        applicationDao.save(new Application(userId, description));
        applicationDao.close();
    }
    
}
