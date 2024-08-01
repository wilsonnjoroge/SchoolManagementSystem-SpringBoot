package com.brightstarschool.schoolmanagementsystem.dto;

import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {
    private long studentId;
    private String admissionNumber;
    private String name;
    private String adress;
    private long phoneNumber = 0;
    private String email;
    private long idNumber = 0;
    private long currentTermId = 0;
    private long totalFeeBilled = 0;
    private long totalPaidFee = 0;
    private long feeBalance = 0;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
