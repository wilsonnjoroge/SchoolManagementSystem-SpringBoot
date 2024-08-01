package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeesPerTermSaveDTO {
    private double term;
    private LocalDate termStartDate;
    private LocalDate termEndDate;
    private long feeCharged;
}
