package ru.geekbrains.lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

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
        if(req.getParameter("add")!=null){
            req.getRequestDispatcher("/WEB-INF/views/header.jsp").include(req,resp);
            req.getRequestDispatcher("/WEB-INF/views/product_form.jsp").include(req,resp);
        } else {
            if(req.getParameter("id")!=null){
                req.setAttribute("id",req.getParameter("id"));
            } else req.setAttribute("id","Enter id");
            if(req.getParameter("product")!=null){
                req.setAttribute("product",req.getParameter("product"));
            } else req.setAttribute("product","Enter product name");
            if(req.getParameter("dateOfAdding")!=null){
                req.setAttribute("dateOfAdding",req.getParameter("dateOfAdding"));
            } else req.setAttribute("dateOfAdding","гггг-мм-дд");
            req.getRequestDispatcher("/WEB-INF/views/header.jsp").include(req,resp);
            req.getRequestDispatcher("/WEB-INF/views/product.jsp").include(req,resp);
        }

    }
}
