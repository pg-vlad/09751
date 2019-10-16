package com.skiteldev.myapplication;

import java.sql.SQLException;

import static com.skiteldev.myapplication.Connection_to_DB.getConnection;
import static com.skiteldev.myapplication.Connection_to_DB.getPreparedStatement;
import static com.skiteldev.myapplication.Connection_to_DB.getSet;
import static com.skiteldev.myapplication.Connection_to_DB.setPreparedStatement;
import static com.skiteldev.myapplication.Connection_to_DB.setResultSet;

class UserDAO {

    static boolean findUser(String user, String pass) {
        String SQL = "SELECT * FROM users where username = ? and password = ?";
        try {
            setPreparedStatement(getConnection().prepareStatement(SQL));
            getPreparedStatement().setString(1, user);
            getPreparedStatement().setString(2, pass);
            setResultSet(getPreparedStatement().executeQuery());
            return getSet().next();
        } catch (SQLException e) {
            return false;
        }
    }
}
