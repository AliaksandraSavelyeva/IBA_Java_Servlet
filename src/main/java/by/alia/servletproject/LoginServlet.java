package by.alia.servletproject;

import by.alia.servletproject.dao.UserDao;
import by.alia.servletproject.model.ListService;
import by.alia.servletproject.util.HashPassword;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();

        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            request.getSession().setAttribute("name", name);
            response.sendRedirect(request.getContextPath()+"/GroupListServlet");
        } else {
            request.setAttribute("errorMessage", "Invalid Login and password!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("service");
    }
}
