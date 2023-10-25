package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.CommentDao;
import ru.kpfu.itis.sergeev.Dao.PostDao;
import ru.kpfu.itis.sergeev.Dao.UserDao;
import ru.kpfu.itis.sergeev.Dto.CommentDto;
import ru.kpfu.itis.sergeev.Dto.PostDto;
import ru.kpfu.itis.sergeev.Dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "postServlet", urlPatterns = "/post")
public class PostServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int post_id;
        try {
            post_id = Integer.parseInt(request.getParameter("postId"));
        }
        catch (RuntimeException exception) {
            post_id = (int) session.getAttribute("postId");
        }
        PostDto post = PostDao.getPost(post_id);
        List<CommentDto> comments = CommentDao.getPostComments(post_id);
        String login = (String) session.getAttribute("login");
        boolean auth = login != null;
        UserDto user = UserDao.getUser(login);
        List<UserDto> users = new ArrayList<>();
        List<Integer> usersID = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            UserDto commentUser = UserDao.getUser(comments.get(i).getUserId());
            assert user != null;
            assert commentUser != null;
            if (!usersID.contains(commentUser.getUserId())) {
                usersID.add(commentUser.getUserId());
            }
        }
        for (int i = 0; i < usersID.size(); i++) {
            UserDto commentUser = UserDao.getUser(usersID.get(i));
            users.add(commentUser);
        }
        if (post == null) {
            response.sendRedirect("error.html");
        } else {
            request.setAttribute("users", users);
            request.setAttribute("user", user);
            request.setAttribute("auth", auth);
            request.setAttribute("post", post);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("post.ftl");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("comment");
        HttpSession session = req.getSession(true);
        int postId = Integer.parseInt(req.getParameter("postId"));
        String login = (String) session.getAttribute("login");
        UserDto user = UserDao.getUser(login);
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        String year = String.valueOf(timestamp.toLocalDateTime().getYear());
        String month = String.valueOf(timestamp.toLocalDateTime().getMonthValue());
        String day = String.valueOf(timestamp.toLocalDateTime().getDayOfMonth());
        String hour = String.valueOf(timestamp.toLocalDateTime().getHour());
        String minute = String.valueOf(timestamp.toLocalDateTime().getMinute());
        if (month.length() == 1) month = "0" + month;
        if (day.length() == 1) day = "0" + day;
        if (hour.length() == 1) hour = "0" + hour;
        if (minute.length() == 1) minute = "0" + minute;
        String date = year + "." + month + "." + day + " " + hour + ":" + minute;
        if (user != null && comment != null) {
            boolean added = CommentDao.addComment(user.getUserId(), postId, comment, date);
            if (!added ) {
                resp.sendRedirect("error.html");
            } else {
                session.setAttribute("postId", postId);
                resp.sendRedirect("post");
            }
        } else {
            resp.sendRedirect("error.html");
        }
    }
}