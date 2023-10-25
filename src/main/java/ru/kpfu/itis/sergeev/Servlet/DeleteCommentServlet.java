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

@WebServlet(name = "deleteCommentServlet", urlPatterns = "/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
    public String login;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int post_id = Integer.parseInt(request.getParameter("postId"));
        int comment_id = Integer.parseInt(request.getParameter("commentId"));
        String login = (String) session.getAttribute("login");
        System.out.println("Comment id: " + comment_id);
        System.out.println("Post id: " + post_id);
        if (login == null) {
            resp.sendRedirect("error.html");
        } else {
            this.login = login;
            CommentDao.deleteComment(post_id, comment_id);
            session.setAttribute("postId", post_id);
            resp.sendRedirect("post");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}