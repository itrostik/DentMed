package ru.kpfu.itis.sergeev.Servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.sergeev.Service.AuthenticationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final AuthenticationController authenticationController = new AuthenticationController();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.html");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            boolean checked = authenticationController.checkUser(login, password);
            if (checked) {
                LOGGER.info("User with login {} logged in", login);
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("login", login);
                httpSession.setMaxInactiveInterval(60 * 60);
                // cookie
                Cookie cookie = new Cookie("login", login);
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
                response.sendRedirect("/user");
            }
            else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}