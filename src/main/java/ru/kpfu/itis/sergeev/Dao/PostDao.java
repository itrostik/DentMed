package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.PostDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    public static boolean addPost(String title, String content, int authorId) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "INSERT INTO posts (title, content, time, author_id, post_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setInt(4, authorId);
            List <PostDto> postList = PostDao.getAllPosts();
            statement.setInt(5, postList.size());

            int rowsInserted = statement.executeUpdate();
            statement.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public static void deletePost(int post_id) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "DELETE FROM posts WHERE post_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, post_id);
            int rows = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PostDto getPost(int postId) {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM posts WHERE post_id = (?)";
        PostDto post = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                post = new PostDto();
                post.setPostId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setAuthorId(resultSet.getInt("author_id"));
                post.setDate(resultSet.getDate("time"));
            }
            return post;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<PostDto> getAllPosts() {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM posts ORDER BY time DESC;";
        List<PostDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PostDto post = new PostDto();
                post.setPostId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setAuthorId(resultSet.getInt("author_id"));
                post.setDate(resultSet.getDate("time"));
                list.add(post);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
}
