package za.ac.cput.utils;

import java.util.UUID;

public class Helper {
    // Checks if the input is a valid string and isn't null
    public static boolean isEmpty(String check) {
        if (check.isEmpty() || check.isBlank()) {
            return false;
        }
        return true;
    }

    // Checks if the input is a valid integer
    public static boolean isEmpty(int check) {
        if (check <= 0) {
            return false;
        }
        return true;
    }

    // Generates a random string using UUID
    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
