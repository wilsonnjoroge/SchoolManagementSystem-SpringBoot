package com.brightstarschool.schoolmanagementsystem.dto;

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
    private String name;
    private String adress;
    private long phoneNumber = 0;
    private String email;
    private long idNumber = 0;
    private String password;
    private long totalFeeBilled;
    private long totalPaidFee;
    private long feeBalance;
}
