package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.PostDao;
import ru.kpfu.itis.sergeev.Dao.UserDao;
import ru.kpfu.itis.sergeev.Dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addPostServlet", urlPatterns = "/addPost")
public class AddPostServlet extends HttpServlet {
    public String login;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        if (login == null) {
            resp.sendRedirect("error.html");
        } else {
            this.login = login;
            resp.sendRedirect("addPost.html");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        UserDto user = UserDao.getUser(this.login);
        if (user != null) {
            boolean added = PostDao.addPost(title, content, user.getUserId());
            if (added) {
                response.sendRedirect("posts");
            } else {
                response.sendRedirect("error.html");
            }
        } else {
            response.sendRedirect("error.html");
        }
    }
}