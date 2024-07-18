package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    String updateStudent(long id,StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(long id);
}
