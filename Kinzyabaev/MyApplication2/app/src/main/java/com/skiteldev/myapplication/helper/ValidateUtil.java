package com.skiteldev.myapplication.helper;

public class ValidateUtil {
    public static boolean validate(String log, String pass) {
        if (log.isEmpty() || pass.isEmpty()) return false;
        return !hasSpecialSymb(log) && !hasSpecialSymb(pass);
    }

    private static boolean hasSpecialSymb(String text) {
        return !text.matches("^[0-9|a-z|A-Z]+$");
    }
}
