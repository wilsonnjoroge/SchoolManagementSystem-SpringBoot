package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.Utils.EmailsManagement;
import com.brightstarschool.schoolmanagementsystem.Utils.NumberGenerator;
import com.brightstarschool.schoolmanagementsystem.Utils.TokenHasher;
import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordDTO;
import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordResponseDto;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgotPasswordServiceImplementation {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private NumberGenerator numberGenerator;
    private TokenHasher tokenHasher;
    private EmailsManagement emailsManagement;

    @Autowired
    public ForgotPasswordServiceImplementation(StudentRepository studentRepository,
                                               TeacherRepository teacherRepository,
                                               NumberGenerator numberGenerator,
                                               TokenHasher tokenHasher,
                                               EmailsManagement emailsManagement) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.numberGenerator = numberGenerator;
        this.tokenHasher = tokenHasher;
        this.emailsManagement = emailsManagement;
    }

    public ForgotPasswordResponseDto forgotPassword(ForgotPasswordDTO forgotPasswordDto)
    {

        Optional<Student> studentOptional = studentRepository.findByEmail(forgotPasswordDto.getEmail());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            String token = numberGenerator.generateRandomNumber();

            String hashedToken = tokenHasher.hashToken(token);
            student.setResetToken(hashedToken);
            studentRepository.save(student);

            // Prepare email details
            String emailBody = "Your password reset token is: " + token;
            emailsManagement.sendEmail(student.getEmail(), "Password Reset Token", emailBody);

            return new ForgotPasswordResponseDto (
                    "Token send Successfully",
                    student.getEmail(),
                    token
            );
        }

        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(forgotPasswordDto.getEmail());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();

            String token = numberGenerator.generateRandomNumber();

            String hashedToken = tokenHasher.hashToken(token);
            teacher.setResetToken(hashedToken);
            teacherRepository.save(teacher);

            // Prepare email details
            String emailBody = "Your password reset token is: " + token;
            emailsManagement.sendEmail(teacher.getEmail(), "Password Reset Token", emailBody);

            return new ForgotPasswordResponseDto (
                    "Token send Successfully",
                    teacher.getEmail(),
                    token
            );
        }

        return new ForgotPasswordResponseDto(
                "Token send Successfully",
                null,
                null
                );
    };

    }
