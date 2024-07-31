package com.brightstarschool.schoolmanagementsystem.Utils;

import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class NumberGenerator {

    // Method to generate a random token
    public String generateRandomNumber() {
        Random random = new Random();
        int token = 100000 + random.nextInt(900000);
        return String.valueOf(token);
    }

    // Method to generate a sequential 4-digit number with prefix BS
    public String generateSequentialNumber(int currentSequenceNumber) {
        return String.format("BS%04d", currentSequenceNumber);
    }
}

