package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.Utils.EmailsManagement;
import com.brightstarschool.schoolmanagementsystem.dto.TeacherSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationTeacher;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationTeacherServiceImpplementation implements AuthenticationTeacher {
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;
    private EmailsManagement emailsManagement;

    @Autowired
    public AuthenticationTeacherServiceImpplementation(TeacherRepository teacherRepository,
                                                       PasswordEncoder passwordEncoder,
                                                       EmailsManagement emailsManagement) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailsManagement = emailsManagement;
    }

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
            String verificationToken = RandomStringUtils.randomAlphanumeric(32);


            Teacher teacher = new Teacher(
                    teacherSaveDTO.getName(),
                    teacherSaveDTO.getAdress(),
                    teacherSaveDTO.getPhoneNumber(),
                    teacherSaveDTO.getEmail(),
                    teacherSaveDTO.getIdNumber(),
                    encodedPassword,
                    "",
                    "",
                    verificationToken,
                    false,
                    false
            );

            teacherRepository.save(teacher);

            String emailBody = "Dear " + teacherSaveDTO.getName() + ",\nWelcome to Bright Star School. We are pleased to have you aboard.\nPlease verify your email by clicking the link below:\n" +
                    "http://localhost:5555/api/v1/teachers/verify-email?token=" + verificationToken;

            emailsManagement.sendEmail(teacherSaveDTO.getEmail(), "Registration Successful", emailBody);

            return teacher.getName();

        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

    public boolean verifyEmail(String token) {
        Optional<Teacher> teacherOptional = teacherRepository.findByVerificationToken(token);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            teacher.setEmailVerified(true);
            teacher.setVerificationToken(null);
            teacherRepository.save(teacher);
            return true;
        }
        return false;
    }
}
