package ru.kpfu.itis.sergeev.Servlet;


import ru.kpfu.itis.sergeev.Dao.ReviewDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "deleteReviewServlet", urlPatterns = "/deleteReview")
public class DeleteReviewServlet extends HttpServlet {
    public String login;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        String login = (String) session.getAttribute("login");
        if (login == null) {
            resp.sendRedirect("error.html");
        } else {
            this.login = login;
            ReviewDao.deleteReview(doctorId, reviewId);
            session.setAttribute("doctorId", doctorId);
            resp.sendRedirect("doctor");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}