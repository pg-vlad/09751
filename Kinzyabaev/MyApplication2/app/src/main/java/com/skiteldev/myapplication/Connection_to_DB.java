package com.skiteldev.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Connection_to_DB {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "your pass";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet set;

    static Connection getConnection() {
        return connection;
    }

    static void setPreparedStatement(PreparedStatement preparedStatement) {
            Connection_to_DB.preparedStatement = preparedStatement;
    }

    static void setResultSet(ResultSet set) {
        Connection_to_DB.set = set;
    }

    static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    static ResultSet getSet() {
        return set;
    }


    static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            connection = null;
            e.printStackTrace();
        }
    }

    static void close_DB() {
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
