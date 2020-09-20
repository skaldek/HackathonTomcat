package com.hack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hack.dao.ApplicationDao;
import com.hack.models.Application;

@WebServlet("/application_list")
public class ApplicationListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationDao applicationDao = new ApplicationDao();
        String userId = req.getParameter("userId");
        List<Application> applications = applicationDao.findAllUser(userId);
        String json = new Gson().toJson(applications);
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        applicationDao.close();
    }
    
}
