package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {
    private int studentId;
    private String studentName;
    private String adress;
    private String phoneNumber;
}
