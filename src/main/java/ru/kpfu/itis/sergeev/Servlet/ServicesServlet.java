package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.UserDao;
import ru.kpfu.itis.sergeev.Dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "servicesServlet", urlPatterns = "/services")
public class ServicesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        if (login == null) {
            response.sendRedirect("error.html");
        }
        UserDto user = UserDao.getUser(login);
        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("services.ftl");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.html");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}