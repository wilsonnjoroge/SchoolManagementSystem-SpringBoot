package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.service.implementation.ForgotPasswordServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.implementation.LogInServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.implementation.ResetPasswordServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/authentication")
public class AuthenticationController {
    private LogInServiceImplementation logInServiceImplementation;
    private ForgotPasswordServiceImplementation forgotPasswordServiceImplementation;
    private ResetPasswordServiceImplementation resetPasswordService;

    @Autowired
    public AuthenticationController(
            LogInServiceImplementation logInServiceImplementation,
            ForgotPasswordServiceImplementation forgotPasswordServiceImplementation,
            ResetPasswordServiceImplementation resetPasswordService
    ) {
        this.logInServiceImplementation = logInServiceImplementation;
        this.forgotPasswordServiceImplementation = forgotPasswordServiceImplementation;
        this.resetPasswordService = resetPasswordService;
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        LogInResponseDTO responseDTO = logInServiceImplementation.authenticateUser(loginDTO);
        if (responseDTO.getMessage().contains("successful")) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
        }
    }

    @PostMapping(path = "/forgot-password")
    public ResponseEntity<ForgotPasswordResponseDto> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDto) {
        ForgotPasswordResponseDto forgotPasswordResponseDto = forgotPasswordServiceImplementation.forgotPassword(forgotPasswordDto);
        if (forgotPasswordResponseDto.getMessage().contains("successful")) {
            return ResponseEntity.ok(forgotPasswordResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(forgotPasswordResponseDto);
        }
    }


    @PutMapping(path = "/reset-password")
    public ResponseEntity<ResetPasswordResponseDTO> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        ResetPasswordResponseDTO response = resetPasswordService.resetPassword(resetPasswordDTO);
        return ResponseEntity.ok(response);
    }

}
