package ru.kpfu.itis.sergeev.Servlet;

import ru.kpfu.itis.sergeev.Dao.*;
import ru.kpfu.itis.sergeev.Dto.*;

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

@WebServlet(name = "doctorServlet", urlPatterns = "/doctor")
public class DoctorServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int doctorId;
        try {
            doctorId = Integer.parseInt(request.getParameter("doctorId"));
        }
        catch (RuntimeException exception) {
            doctorId = (int) session.getAttribute("doctorId");
        }
        DoctorDto doctor = DoctorDao.getDoctor(doctorId);
        List<ReviewDto> reviews = ReviewDao.getDoctorReviews(doctorId);
        String login = (String) session.getAttribute("login");
        boolean auth = login != null;
        UserDto user = UserDao.getUser(login);
        List<UserDto> users = new ArrayList<>();
        List<Integer> usersID = new ArrayList<>();
        for (int i = 0; i < reviews.size(); i++) {
            UserDto reviewUser = UserDao.getUser(reviews.get(i).getUserId());
            assert user != null;
            assert reviewUser != null;
            if (!usersID.contains(reviewUser.getUserId())) {
                usersID.add(reviewUser.getUserId());
            }
        }
        for (int i = 0; i < usersID.size(); i++) {
            UserDto commentUser = UserDao.getUser(usersID.get(i));
            users.add(commentUser);
        }
        if (doctor == null) {
            response.sendRedirect("error.html");
        } else {
            request.setAttribute("users", users);
            request.setAttribute("user", user);
            request.setAttribute("auth", auth);
            request.setAttribute("doctor", doctor);
            request.setAttribute("reviews", reviews);
            RequestDispatcher dispatcher = request.getRequestDispatcher("doctor.ftl");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String review = req.getParameter("review");
        HttpSession session = req.getSession(true);
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
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
        if (user != null && review != null) {
            boolean added = ReviewDao.addReview(user.getUserId(), doctorId, review, date);
            if (!added ) {
                resp.sendRedirect("error.html");
            } else {
                session.setAttribute("doctorId", doctorId);
                resp.sendRedirect("doctor");
            }
        } else {
            resp.sendRedirect("error.html");
        }
    }
}