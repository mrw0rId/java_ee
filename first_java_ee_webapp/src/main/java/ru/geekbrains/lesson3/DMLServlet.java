package ru.geekbrains.lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

@WebServlet(urlPatterns = "/dml")
public class DMLServlet extends HttpServlet {

    CatalogDB catalogDB;

    @Override
    public void init() throws ServletException {
        catalogDB = (CatalogDB) getServletContext().getAttribute("catalogDB");
        if (catalogDB == null) {
            throw new ServletException("catalogDB is not initialized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = req.getParameter("dateOfAddingInput");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate dateOfAdding = null;
        try {
            dateOfAdding = formatter.parse(date).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String product = req.getParameter("productInput");
        String photoUrl = req.getParameter("photoInput");
        try {
            catalogDB.insert(new Product(product, dateOfAdding));
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher(getServletContext().getContextPath()+"/product").forward(req,resp);
//        resp.sendRedirect(getServletContext().getContextPath()+"/product");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
