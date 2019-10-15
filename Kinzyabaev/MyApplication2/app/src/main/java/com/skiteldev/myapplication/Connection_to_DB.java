package com.skiteldev.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection_to_DB {
    private static final String URL = "your url";
    private static final String USER = "your username";
    private static final String PASSWORD = "your pass";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet set;

    public static void setPreparedStatement(PreparedStatement preparedStatement) {
        Connection_to_DB.preparedStatement = preparedStatement;
    }

    public static void setResultSet(ResultSet set) {
        Connection_to_DB.set = set;
    }

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            connection = null;
            e.printStackTrace();
        }
        return connection;
    }

    public void close_DB() {
        try {
            connection.close();
            connection = null;
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
