package ru.geekbrains.lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    CatalogDB catalogDB;

    @Override
    public void init() throws ServletException {
        catalogDB = (CatalogDB) getServletContext().getAttribute("catalogDB");
        if(catalogDB == null){
            throw new ServletException("catalogDB is not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> productList = catalogDB.findAll();
            req.setAttribute("productList",productList);
            req.getRequestDispatcher("/WEB-INF/views/header.jsp").include(req,resp);
            req.getRequestDispatcher("/WEB-INF/views/catalog.jsp").include(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
