package org.example;

public class PasswordUtil {
    public enum SecurityLevel {
        WEAK,
        MEDIUM,
        STRONG
    }
    public static SecurityLevel assessPassword(String password) {
        if (password == null || password.isEmpty() || password.length() < 8) {
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }
        if (password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*")) {
            return SecurityLevel.STRONG;
        }
        return SecurityLevel.WEAK;
    }
    
}