package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentSaveDTO {
    private long enrollmentId;

    private long studentId;

    private long batchId;

    private String joinDate;

    private int fee;
}
