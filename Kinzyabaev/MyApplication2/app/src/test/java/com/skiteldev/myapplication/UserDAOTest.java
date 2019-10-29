package com.skiteldev.myapplication;

import com.skiteldev.myapplication.connection.PostgresConnection;
import com.skiteldev.myapplication.connection.UserDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {

    @BeforeClass
    public static void initDB() {
        PostgresConnection.connect();
    }

    @AfterClass
    public static void close() {
        PostgresConnection.close_DB();
    }
    @Test
    public void findUser() {
        assertTrue(UserDAO.findUser("aa","aa"));
        assertFalse(UserDAO.findUser("43", "43"));
        assertFalse(UserDAO.findUser("*", "*"));
        assertFalse(UserDAO.findUser("aa", "*"));
        assertFalse(UserDAO.findUser("", "aa"));
    }
}