package com.skiteldev.myapplication;

public class ValidateUtil {
    public static boolean validate(String log, String pass) {
        if (log.isEmpty() || pass.isEmpty()) return false;
        if (hasSpecialSymb(log) || hasSpecialSymb(pass)) return false;
        return true;
    }

    private static boolean hasSpecialSymb(String text) {
        return !text.matches("^[0-9|a-z|A-Z]+$");
    }
}
