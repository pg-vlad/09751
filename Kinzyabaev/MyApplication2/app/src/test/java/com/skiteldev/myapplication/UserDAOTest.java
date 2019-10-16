package com.skiteldev.myapplication;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDAOTest {

    @BeforeClass
    public static void initDB() {
        Connection_to_DB.connect();
    }

    @AfterClass
    public static void close() {
        Connection_to_DB.close_DB();
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