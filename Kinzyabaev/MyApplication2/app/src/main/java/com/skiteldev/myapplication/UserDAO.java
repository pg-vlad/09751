package com.skiteldev.myapplication;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO extends Connection_to_DB{
    private Connection connection = getConnection();
    @Override
    public void performStatement() {
        String SQL = "SELECT * FROM developers";
        try {
            setPreparedStatement(connection.prepareStatement(SQL));
            getPreparedStatement().executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findRecord() {
    }

    public boolean findUser(String user, String pass) {
        boolean isExistUser = false;
        try {
            connection
        return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
