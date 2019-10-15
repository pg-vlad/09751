package com.skiteldev.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Connection_to_DB {
    private static final String URL = "your url";
    private static final String USER = "your username";
    private static final String PASSWORD = "your pass";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet set;

    public static Connection getConnection() {
        return connection;
    }

    public static void setPreparedStatement(PreparedStatement preparedStatement) {
            Connection_to_DB.preparedStatement = preparedStatement;
    }

    public static void setResultSet(ResultSet set) {
        Connection_to_DB.set = set;
    }

    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static ResultSet getSet() {
        return set;
    }

    public abstract void performStatement();
    public abstract void findRecord();

    public static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            connection = null;
            e.printStackTrace();
        }
    }

    public static void close_DB() {
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
