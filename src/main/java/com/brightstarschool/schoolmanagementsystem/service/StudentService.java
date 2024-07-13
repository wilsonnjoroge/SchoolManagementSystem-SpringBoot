package com.brightstarschool.schoolmanagementsystem.service;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();
}
