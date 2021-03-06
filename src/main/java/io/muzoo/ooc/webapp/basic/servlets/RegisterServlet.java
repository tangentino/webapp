package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends AbstractRoutableHttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
        dispatcher.include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.addUser(request)) {
            response.sendRedirect("/");
        }
        else {
            request.setAttribute("info","Registration failed. Please try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
            dispatcher.include(request,response);
        }
    }

    @Override
    public String getPattern() {
        return "/register";
    }
}
