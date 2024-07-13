package com.brightstarschool.schoolmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int studentId;
    private String studentName;
    private String adress;
    private String phoneNumber;
}
