package ru.kpfu.itis.sergeev.Service;

import ru.kpfu.itis.sergeev.Dao.UserDao;
import java.sql.SQLException;

public class AuthenticationController {
    public boolean checkUser(String login, String password) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.checkUser(login, password);
    }
}
