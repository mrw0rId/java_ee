package ru.geekbrains.test_classes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author = Ilnur
 * Класс для практики по методичке
 */
@WebServlet(name = "FirstHttpServlet", urlPatterns = "/http_servlet/*")
public class FirstHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String servletPath = req.getServletPath();
        resp.getWriter().println("<h1>Проверка русского</h1>");
        resp.getWriter().printf("<p>Header: %s</p>", req.getHeader("User-agent"));
        resp.getWriter().printf("<p>Connection: %s</p>", req.getHeader("Connection"));
        resp.getWriter().printf("<p>HttpServlet URL path: %s</p>", servletPath);
        resp.getWriter().printf("<p>HttpServlet URL param1:%s, param2:%s</p>", req.getParameter("param1"), req.getParameter("param2"));
        resp.getWriter().printf("<p>New POST request with body %s</p>", readAllLines(req.getReader()));
        resp.getWriter().println(resp.getStatus());
        resp.getWriter().println(getServletContext().getContextPath());
        resp.getWriter().println(req.getContextPath());
//        resp.sendRedirect(req.getContextPath()+"/first_servlet");
//        resp.sendRedirect("https://geekbrains.ru/education");
//        req.getRequestDispatcher("/").forward(req,resp);
//        req.getRequestDispatcher("/index.html").forward(req,resp);
//        req.getRequestDispatcher("/header.html").include(req,resp);
//        req.getRequestDispatcher("/fotter.html").include(req,resp);
//        HttpSession session = req.getSession();
//        session.setMaxInactiveInterval(10*60);
//        Cookie cookie = new Cookie("User", "Mike");
//        resp.addCookie(cookie);

    }

    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
