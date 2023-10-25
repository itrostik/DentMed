package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.CommentDao;
import ru.kpfu.itis.sergeev.Dao.PostDao;
import ru.kpfu.itis.sergeev.Dao.UserDao;
import ru.kpfu.itis.sergeev.Dto.PostDto;
import ru.kpfu.itis.sergeev.Dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "deletePostServlet", urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {
    public String login;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int post_id = Integer.parseInt(request.getParameter("postId"));
        String login = (String) session.getAttribute("login");
        if (login == null) {
            resp.sendRedirect("error.html");
        } else {
            this.login = login;
            PostDao.deletePost(post_id);
            CommentDao.deleteComments(post_id);
            resp.sendRedirect("posts");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}