package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.MessageDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public static boolean addMessage(int user_id, String message_text, String time) {
        try {
            List<MessageDto> messages = MessageDao.getMessages();
            Connection con = DatabaseConnectionUtil.getConnection();
            String sql = "INSERT INTO messages (user_id, message_text, time, message_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setString(2, message_text);
            statement.setString(3, time);
            statement.setInt(4, messages.size());
            int rowsInserted = statement.executeUpdate();
            statement.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void deleteMessage(int message_id, int user_id) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            String sql = "DELETE FROM messages WHERE user_id = ? AND message_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, message_id);
            statement.setInt(2, user_id);
            int rows = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<MessageDto> getMessages() {
        Connection con = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM messages";
        List<MessageDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MessageDto messageDto = new MessageDto();
                messageDto.setMessageId(resultSet.getInt("message_id"));
                messageDto.setUserId(resultSet.getInt("user_id"));
                messageDto.setMessageText(resultSet.getString("message_text"));
                messageDto.setMessageDate(resultSet.getString("time"));
                list.add(messageDto);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }

}
