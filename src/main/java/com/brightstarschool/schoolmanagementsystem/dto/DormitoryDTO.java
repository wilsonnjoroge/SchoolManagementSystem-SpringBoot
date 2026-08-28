package com.brightstarschool.schoolmanagementsystem.dto;

import com.brightstarschool.schoolmanagementsystem.entity.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryDTO {
    private long dormitoryId;
    private long dormCode;
    private String dormName;
}
