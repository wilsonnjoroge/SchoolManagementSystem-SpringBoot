package com.brightstarschool.schoolmanagementsystem.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class TokenHasher {

    // Hash a token
    public static String hashToken(String token) {
        return BCrypt.hashpw(token, BCrypt.gensalt());
    }

    // Validate a token
    public static boolean validateResetToken(String hashedToken, String resetCode) {
        return BCrypt.checkpw(resetCode, hashedToken);
    }
}
