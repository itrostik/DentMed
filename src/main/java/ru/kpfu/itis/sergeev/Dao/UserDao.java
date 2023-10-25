package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.UserDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.sergeev.Utils.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static boolean addUser(String firstName, String lastName, String login, String password, String address, String phoneNumber, String email) throws SQLException {
        String hashPassword = PasswordUtil.encrypt(password);
        Connection connection = DatabaseConnectionUtil.getConnection();
        String query = "INSERT INTO users (first_name, last_name, login, password_hash, address, phone_number, email, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        List<UserDto> userList = UserDao.getAllUsers();
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, login);
        statement.setString(4, hashPassword);
        statement.setString(5, address);
        statement.setString(6, phoneNumber);
        statement.setString(7, email);
        statement.setInt(8, userList.size());
        int rows = statement.executeUpdate();
        statement.close();
        return rows > 0;
    }

    public static UserDto getUser(int user_id) {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE user_id = (?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            UserDto user = null;
            if (resultSet.next()) {
                user = new UserDto();
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password_hash"));
                user.setLastName(resultSet.getString("last_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
            }

            resultSet.close();
            statement.close();
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    public static UserDto getUser(String login) {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE login = (?)";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            UserDto user = null;
            if (resultSet.next()) {
                user = new UserDto();
                user.setUserId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password_hash"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setEmail(resultSet.getString("email"));
            }


            resultSet.close();
            statement.close();
            return user;
        } catch (SQLException e) {
            return null;
        }

    }

    public boolean checkUser(String login, String password) {
        String hashPassword = PasswordUtil.encrypt(password);
        try {
            UserDto user = getUser(login);
            if (user == null) {
                return false;
            }
            return user.getLogin().equals(login) && user.getHashPassword().equals(hashPassword);

        } catch (Exception e) {
            return false;
        }
    }
    public static List<UserDto> getAllUsers() {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM users";
        List<UserDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserDto user = new UserDto();
                user.setUserId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password_hash"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
}