package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private long teacherId;
    private String teacherName;
    private String adress;
    private String phoneNumber;
    private String email;
    private long idNumber;
}
