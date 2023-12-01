package ru.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;


//@WebServlet(value = "/users/*", loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        writer.write("Hello World from Servlet");
        writer.write("</body>");
        writer.write("</html>");
    }
}
