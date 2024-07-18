package com.brightstarschool.schoolmanagementsystem.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class RandomNumberGenerator {

    @Bean
    public String generateToken() {
        SecureRandom random = new SecureRandom();
        int token = 100000 + random.nextInt(900000);
        return String.valueOf(token);
    }
}
