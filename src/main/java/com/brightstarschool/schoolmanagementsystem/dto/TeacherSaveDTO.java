package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSaveDTO {
    private String name;
    private String adress;
    private String phoneNumber;
    private String email;
    private long idNumber;
    private String password;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
