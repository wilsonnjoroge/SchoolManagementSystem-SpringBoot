package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeesPerTermUpdateDTO {
    private double term = 0;
    private LocalDate termStartDate;
    private LocalDate termEndDate;
    private long feeCharged = 0;
}
