package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchUpdateDTO {

    private long batchId;

    private String batchName;

    private long courseId;

    private String startDate;
}
