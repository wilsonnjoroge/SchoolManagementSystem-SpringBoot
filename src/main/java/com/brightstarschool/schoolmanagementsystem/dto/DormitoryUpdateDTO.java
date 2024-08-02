package com.brightstarschool.schoolmanagementsystem.dto;


import com.brightstarschool.schoolmanagementsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryUpdateDTO {
    private long dormCode;
    private String dormName;
}
