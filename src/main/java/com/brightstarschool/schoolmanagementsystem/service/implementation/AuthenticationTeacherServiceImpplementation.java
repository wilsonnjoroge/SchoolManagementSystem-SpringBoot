package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.TeacherSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTeacherServiceImpplementation implements AuthenticationTeacher {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        try {
            Teacher teacher = new Teacher(
                    teacherSaveDTO.getTeacherName(),
                    teacherSaveDTO.getAdress(),
                    teacherSaveDTO.getPhoneNumber(),
                    teacherSaveDTO.getEmail()
            );

            teacherRepository.save(teacher);
            System.out.println("\nMessage: Teacher Saved Successfully");

            return teacher.getTeacherName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

}
