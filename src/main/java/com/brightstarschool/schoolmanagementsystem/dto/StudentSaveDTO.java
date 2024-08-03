package com.brightstarschool.schoolmanagementsystem.dto;

import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveDTO {
    private String name;
    private String adress;
    private long phoneNumber;
    private long dormitoryId;
    private long currentTermId;
    private String email;
    private long idNumber;
    private String password;
    private long totalPaidFee;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
