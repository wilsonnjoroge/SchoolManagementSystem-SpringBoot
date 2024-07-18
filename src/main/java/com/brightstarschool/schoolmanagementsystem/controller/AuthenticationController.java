package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordDto;
import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordResponseDto;
import com.brightstarschool.schoolmanagementsystem.dto.LogInResponseDTO;
import com.brightstarschool.schoolmanagementsystem.dto.LoginDTO;
import com.brightstarschool.schoolmanagementsystem.service.implementation.ForgotPasswordServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.implementation.LogInServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private LogInServiceImplementation logInServiceImplementation;

    @Autowired
    private ForgotPasswordServiceImplementation forgotPasswordServiceImplementation;

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        LogInResponseDTO responseDTO = logInServiceImplementation.authenticateUser(loginDTO);
        if (responseDTO.getMessage().contains("successful")) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ForgotPasswordResponseDto> forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        ForgotPasswordResponseDto forgotPasswordResponseDto = forgotPasswordServiceImplementation.forgotPassword(forgotPasswordDto);
        if (forgotPasswordResponseDto.getMessage().contains("successful")) {
            return ResponseEntity.ok(forgotPasswordResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(forgotPasswordResponseDto);
        }
    }
}
