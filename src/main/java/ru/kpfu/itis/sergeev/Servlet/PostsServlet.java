package ru.kpfu.itis.sergeev.Servlet;


import ru.kpfu.itis.sergeev.Dao.PostDao;
import ru.kpfu.itis.sergeev.Dao.UserDao;
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
import java.util.*;

@WebServlet(name = "postsServlet", urlPatterns = "/posts")
public class PostsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        boolean auth = login != null;
        List<PostDto> posts = PostDao.getAllPosts();
        List<UserDto> users = new ArrayList<>();
        List<Integer> usersID = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            UserDto user = UserDao.getUser(posts.get(i).getAuthorId());
            assert user != null;
            if (!usersID.contains(user.getUserId())) {
                usersID.add(user.getUserId());
            }
        }
        for (int i = 0; i < usersID.size(); i++) {
            UserDto user = UserDao.getUser(usersID.get(i));
            users.add(user);
        }
        if (posts != null) {
            request.setAttribute("auth", auth);
            UserDto user = UserDao.getUser(login);
            System.out.println(user);
            if (!posts.isEmpty()) request.setAttribute("posts", posts);
            request.setAttribute("users", users);
            if (user != null) {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("posts.ftl");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("posts.ftl");
                dispatcher.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int post = Integer.parseInt(req.getParameter("post"));
        HttpSession session = req.getSession(true);
        session.setAttribute("post", post);
        resp.sendRedirect("post");
    }
}
