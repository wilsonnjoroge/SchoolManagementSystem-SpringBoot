package com.brightstarschool.schoolmanagementsystem.dto;

import com.brightstarschool.schoolmanagementsystem.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private long teacherId;
    private String name;
    private String adress;
    private long phoneNumber;
    private String email;
    private long idNumber;
    private Subject subjects;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
