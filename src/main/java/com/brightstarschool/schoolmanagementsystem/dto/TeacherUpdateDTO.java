package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherUpdateDTO {
    private long teacherId;
    private String teacherName;
    private String adress;
    private long phoneNumber = 0;
    private String email;
    private long idNumber = 0;
    private String password;
}
