package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<link rel='stylesheet' href='" + req.getContextPath() + "/style.css'>");

        resp.getWriter().println("<h1>Home</h1>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/home'>Home</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/about'>About</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/contacts'>Contacts</a></li>");
        resp.getWriter().println("</ul>");
    }
}
