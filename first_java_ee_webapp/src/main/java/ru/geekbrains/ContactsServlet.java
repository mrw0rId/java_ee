package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contacts")
public class ContactsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Contacts</h1>");
        resp.getWriter().println("<p>HR: +1 888 000 00-00</p>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/home'>Back Home</a></li>");
        resp.getWriter().println("</ul>");
    }
}
