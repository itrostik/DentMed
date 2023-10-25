package ru.kpfu.itis.sergeev.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    private static Connection connection;
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5433/dantmed";
    public static final String USER = "postgres";
    public static final String PASSWORD = "1234";
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return connection;
    }
}