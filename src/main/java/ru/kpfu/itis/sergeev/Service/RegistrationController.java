package ru.kpfu.itis.sergeev.Service;

import ru.kpfu.itis.sergeev.Dao.UserDao;

import java.sql.SQLException;

public class RegistrationController {
    public boolean registerUser(String firstName, String lastName, String login, String password, String address, String phoneNumber, String email) throws SQLException {
        if (UserDao.getUser(login) == null) {
            return UserDao.addUser(firstName, lastName, login, password, address, phoneNumber, email);
        }
        else {
            return false;
        }
    }
}
