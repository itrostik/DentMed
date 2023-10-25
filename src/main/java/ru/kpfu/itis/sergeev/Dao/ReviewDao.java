package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.CommentDto;
import ru.kpfu.itis.sergeev.Dto.ReviewDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {

    public static boolean addReview(int userId, int doctorId, String reviewText, String date) {
        try {
            List<ReviewDto> reviewsList = getDoctorReviews(doctorId);
            Connection con = DatabaseConnectionUtil.getConnection();
            String sql = "INSERT INTO reviews (user_id, doctor_id, review_text, review_id, date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, doctorId);
            statement.setString(3, reviewText);
            statement.setInt(4, reviewsList.size());
            statement.setString(5, date);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void deleteReview(int doctorId, int reviewId) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "DELETE FROM reviews WHERE doctor_id = ? AND review_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, doctorId);
            statement.setInt(2, reviewId);
            System.out.println("Запрос выполняется...");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ReviewDto> getDoctorReviews(int doctorId) {
        Connection con = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM reviews WHERE doctor_id = (?)";
        List<ReviewDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReviewDto reviewDto = new ReviewDto();
                reviewDto.setReviewId(resultSet.getInt("review_id"));
                reviewDto.setUserId(resultSet.getInt("user_id"));
                reviewDto.setDoctorId(resultSet.getInt("doctor_id"));
                reviewDto.setReviewText(resultSet.getString("review_text"));
                reviewDto.setReviewDate(resultSet.getString("date"));
                list.add(reviewDto);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
    public static List<ReviewDto> getAllReviews() {
        Connection con = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM reviews";
        List<ReviewDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReviewDto reviewDto = new ReviewDto();
                reviewDto.setReviewId(resultSet.getInt("review_id"));
                reviewDto.setUserId(resultSet.getInt("user_id"));
                reviewDto.setDoctorId(resultSet.getInt("doctor_id"));
                reviewDto.setReviewText(resultSet.getString("review_text"));
                reviewDto.setReviewDate(resultSet.getString("date"));
                list.add(reviewDto);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
}
