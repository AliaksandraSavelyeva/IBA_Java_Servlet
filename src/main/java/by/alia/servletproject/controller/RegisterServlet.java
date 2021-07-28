package by.alia.servletproject.controller;

import by.alia.servletproject.dao.UserDao;
import by.alia.servletproject.model.User;
import by.alia.servletproject.util.HashPassword;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/views/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("newLoginName");
        String password = request.getParameter("newPassword");

        UserDao daoUser = new UserDao();
        User user = new User(name, HashPassword.getHash(password));

        if (daoUser.insertUser(user)) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward( request, response);
        } else {
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существет");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp")
                    .forward(request, response);
        }
    }
}
