package ru.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/users/*", loadOnStartup = 1)
public class UsersServlet extends HttpServlet {

    private final UserStorage USER_STORAGE = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if ("/all".equals(action)) {
            req.setAttribute("users", USER_STORAGE.getAll());
            getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req, resp);
        } else if ("/create".equals(action)) {
            getServletContext().getRequestDispatcher("/createUser.jsp").forward(req, resp);
        } else if ("/author".equals(action)) {
            req.setAttribute("author", "Petr Petrov");
            getServletContext().getRequestDispatcher("/author.jsp").forward(req, resp);
        }

        //resp.getWriter().write("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if ("/create".equals(action)) {
            System.out.println("***POST request: " + action);
            String id = req.getParameter("id");
            String firstName = req.getParameter("firstName2");
            String lastName = req.getParameter("lastName");

            USER_STORAGE.create(new UserInfo(id, firstName, lastName));

            req.setAttribute("users", USER_STORAGE.getAll());
            getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest request) {
        String controllerName = "/users";
        String url = request.getRequestURI();
        int controllerStartIndex = url.indexOf(controllerName);

        return url.substring(controllerStartIndex + controllerName.length());
    }
}
