package com.skiteldev.myapplication;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO extends Connection_to_DB{
    @Override
    public void performStatement() {
        String SQL = "SELECT * FROM developers";
        Connection connection = getConnection();
        try {
            setPreparedStatement(connection.prepareStatement(SQL));
            getPreparedStatement().executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showResultSet() {
        String SQL = "SELECT * FROM developers";

    }
}
