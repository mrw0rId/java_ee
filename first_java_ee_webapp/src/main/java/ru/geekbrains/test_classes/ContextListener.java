package ru.geekbrains.test_classes;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        String jdbcConnectionString = context.getInitParameter("jdbcConnectionString");
        String username = context.getInitParameter("dbUsername");
        String password = context.getInitParameter("dbPassword");

        if (isNotNullOrEmpty(jdbcConnectionString) || isNotNullOrEmpty(username)) {return;}
        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            context.setAttribute("jdbcConnection", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Connection conn = (Connection) context.getAttribute("jdbcConnection");
        if (conn == null) {return;}
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isNotNullOrEmpty(String str) {
        return str != null && str.isEmpty();
    }
}
