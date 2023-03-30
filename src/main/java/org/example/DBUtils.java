package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    public static Connection connect() {
        Connection conn = null;


        try {
            String url = "jdbc:sqlite:src/main/resources/DB/AMS.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void insertUser(String username, String password) throws SQLException {
        String query = String.format("INSERT INTO User (username, password) VALUES ('%s', '%s')",
                username, password);
        executeUpdate(query);
    }

    private static void executeUpdate(String query) {
    }

    public static void insertClass(String classname) throws SQLException {
        String query = String.format("INSERT INTO Class (classname) VALUES ('%s')", classname);
        executeUpdate(query);
    }

    public static void insertAttendance(int classId, int userId) throws SQLException {
        String query = String.format("INSERT INTO attendance (classId, userId) VALUES (%d, %d)", classId, userId);
        executeUpdate(query);
    }
    public static ResultSet selectAllUsers() throws SQLException {
        return executeQuery("SELECT * FROM users");
    }

    private static ResultSet executeQuery(String s) {
        return executeQuery("SELECT * FROM classes");
    }


    public static ResultSet selectAllClasses() throws SQLException {
        return executeQuery("SELECT * FROM classes");
    }
}
