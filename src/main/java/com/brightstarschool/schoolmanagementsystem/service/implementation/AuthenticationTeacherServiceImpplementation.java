package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.TeacherSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationTeacherServiceImpplementation implements AuthenticationTeacher {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        try {

            Optional<Teacher> teacherIdExist = teacherRepository.findByIdNumber(teacherSaveDTO.getIdNumber());

            if(teacherIdExist.isPresent())
            {
                return ("Teacher with id: " + teacherSaveDTO.getIdNumber() + " already exists!!");
            };

            Optional<Teacher> teacherEmailExist = teacherRepository.findByEmail(teacherSaveDTO.getEmail());
            if(teacherEmailExist.isPresent())
            {
                return ("Teacher with email: " + teacherSaveDTO.getEmail() + " already exists!!");
            }

            String encodedPassword = passwordEncoder.encode(teacherSaveDTO.getPassword());


            Teacher teacher = new Teacher(
                    teacherSaveDTO.getName(),
                    teacherSaveDTO.getAdress(),
                    teacherSaveDTO.getPhoneNumber(),
                    teacherSaveDTO.getEmail(),
                    teacherSaveDTO.getIdNumber(),
                    encodedPassword,
                    ""
            );

            teacherRepository.save(teacher);
            System.out.println("\nMessage: Teacher Saved Successfully");

            return teacher.getName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

}
