package by.alia.servletproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginRequiredFilter", urlPatterns = "/GroupListServlet")
public class LoginRequiredFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        HttpSession session = httpReq.getSession();
        if ("admin".equals(session.getAttribute("name"))) {
            chain.doFilter(request, response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("LoginServlet")
                    .forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException { }
}
