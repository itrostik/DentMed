package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.CommentDao;
import ru.kpfu.itis.sergeev.Dao.MessageDao;
import ru.kpfu.itis.sergeev.Dao.PostDao;
import ru.kpfu.itis.sergeev.Dao.UserDao;
import ru.kpfu.itis.sergeev.Dto.CommentDto;
import ru.kpfu.itis.sergeev.Dto.MessageDto;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "forumServlet", urlPatterns = "/forum")
public class ForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List<MessageDto> messages = MessageDao.getMessages();
        System.out.println(messages.toString());
        String login = (String) session.getAttribute("login");
        boolean auth = login != null;
        UserDto user = UserDao.getUser(login);
        List<UserDto> users = new ArrayList<>();
        List<Integer> usersID = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            UserDto messageUser = UserDao.getUser(messages.get(i).getUserId());
            assert user != null;
            assert messageUser != null;
            if (!usersID.contains(messageUser.getUserId())) {
                usersID.add(messageUser.getUserId());
            }
        }
        for (int i = 0; i < usersID.size(); i++) {
            UserDto messageUser = UserDao.getUser(usersID.get(i));
            users.add(messageUser);
        }
        if (messages == null) {
            response.sendRedirect("error.html");
        } else {
            request.setAttribute("users", users);
            request.setAttribute("user", user);
            request.setAttribute("auth", auth);
            request.setAttribute("messages", messages);
            RequestDispatcher dispatcher = request.getRequestDispatcher("forum.ftl");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        HttpSession session = req.getSession(true);
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
        if (user != null && message != null) {
            boolean added = MessageDao.addMessage(user.getUserId(), message, date);
            if (!added) {
                resp.sendRedirect("error.html");
            } else {
                resp.sendRedirect("forum");
            }
        } else {
            resp.sendRedirect("error.html");
        }
    }
}