package com.hexaware.bankingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/HMBank";
    private static final String USER = "root";      // 🔁 change if different
    private static final String PASSWORD = "prasanna12@";  // 🔁 change if different

    public static Connection getDBConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
