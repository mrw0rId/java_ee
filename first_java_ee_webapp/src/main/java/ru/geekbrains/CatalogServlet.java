package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Catalog</h1>");
        resp.getWriter().println("<p>For now Catalog is empty</p>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/home'>Back Home</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/cart'>go to Cart</a></li>");
        resp.getWriter().println("<li><a href='" + req.getContextPath() + "/orders'>go to Orders</a></li>");
        resp.getWriter().println("</ul>");
    }
}
