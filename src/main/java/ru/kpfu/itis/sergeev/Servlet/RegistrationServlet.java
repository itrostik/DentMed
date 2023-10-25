package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Service.RegistrationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final RegistrationController registrationController = new RegistrationController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("registration.html");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("number");
        String email = request.getParameter("email");
        try {
            if(registrationController.registerUser(firstName, lastName, login, password, address, phoneNumber, email)) {
                response.sendRedirect("index.ftl");
            }
            else{
                response.sendRedirect("error.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
