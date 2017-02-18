package maciek.controller;

import maciek.domain.Person;
import maciek.service.LoginService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("login")
public class LoginController extends HttpServlet {

    private LoginService loginService;

    @Inject
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession(true).getAttribute("user");
        if (user == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Person person = loginService.verifyCredentials(userName, password);
        if (person != null) {
            request.getSession(true).setAttribute("user", person);
            request.getSession().setAttribute("logged", true);
            request.setAttribute("person", person);
            response.sendRedirect("products");
        } else {
            request.setAttribute("errors", "Invalid credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
}

