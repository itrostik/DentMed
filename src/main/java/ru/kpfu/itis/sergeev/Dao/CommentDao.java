package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.CommentDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public static boolean addComment(int userId, int postId, String commentText, String date) {
        try {
            List<CommentDto> commentsList = getPostComments(postId);
            Connection con = DatabaseConnectionUtil.getConnection();
            String sql = "INSERT INTO comments (user_id, post_id, comment_text, comment_id, date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, postId);
            statement.setString(3, commentText);
            statement.setInt(4, commentsList.size());
            statement.setString(5, date);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void deleteComment(int post_id, int comment_id) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "DELETE FROM comments WHERE post_id = ? AND comment_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, post_id);
            statement.setInt(2, comment_id);
            System.out.println("Запрос выполняется...");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteComments(int post_id) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "DELETE FROM comments WHERE post_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, post_id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<CommentDto> getPostComments(int post_id) {
        Connection con = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM comments WHERE post_id = (?)";
        List<CommentDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, post_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentDto commentDto = new CommentDto();
                commentDto.setCommentId(resultSet.getInt("comment_id"));
                commentDto.setUserId(resultSet.getInt("user_id"));
                commentDto.setPostId(resultSet.getInt("post_id"));
                commentDto.setCommentText(resultSet.getString("comment_text"));
                commentDto.setCommentDate(resultSet.getString("date"));
                list.add(commentDto);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
}
