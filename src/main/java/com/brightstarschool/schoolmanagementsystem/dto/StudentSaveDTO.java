package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveDTO {
    private String admissionNumber;
    private String name;
    private String adress;
    private long phoneNumber;
    private String email;
    private long idNumber;
    private String password;
    private long totalFeeBilled;
    private long totalPaidFee;
    private long feeBalance;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
