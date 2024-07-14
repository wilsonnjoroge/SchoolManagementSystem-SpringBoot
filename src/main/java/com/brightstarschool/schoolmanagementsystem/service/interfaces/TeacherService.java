package com.brightstarschool.schoolmanagementsystem.service;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(long id, TeacherUpdateDTO teacherUpdateDTO);

    boolean deleteTeacher(long id);
}
