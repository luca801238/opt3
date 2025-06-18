package Player;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/url";
    private static final String USER = "root";
    private static final String PASSWORD = "wachtwoord";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}