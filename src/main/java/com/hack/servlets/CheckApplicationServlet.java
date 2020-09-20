package com.hack.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hack.dao.ApplicationDao;
import com.hack.models.Application;

@WebServlet("/check_applications")
public class CheckApplicationServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationDao applicationDao = new ApplicationDao();
        String state = req.getParameter("state");
        String id = req.getParameter("id");
        Application application = applicationDao.find(id);
        application.setState(state);
        applicationDao.update(application);
        applicationDao.close();

    }
    
}
