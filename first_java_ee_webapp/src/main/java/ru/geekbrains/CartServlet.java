package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Cart</h1>");
        resp.getWriter().println("<p>Cart is empty</p>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/home'>Back Home</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/catalog'>go to Catalog</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/orders'>go to Orders</a></li>");
        resp.getWriter().println("</ul>");
    }
}
