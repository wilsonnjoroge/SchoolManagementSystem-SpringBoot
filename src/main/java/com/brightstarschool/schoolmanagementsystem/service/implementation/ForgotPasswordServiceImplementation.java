package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.Utils.RandomNumberGenerator;
import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordDto;
import com.brightstarschool.schoolmanagementsystem.dto.ForgotPasswordResponseDto;
import com.brightstarschool.schoolmanagementsystem.dto.LogInResponseDTO;
import com.brightstarschool.schoolmanagementsystem.dto.LoginDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgotPasswordServiceImplementation {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    public ForgotPasswordResponseDto forgotPassword(ForgotPasswordDto forgotPasswordDto)
    {
        Optional<Student> studentOptional = studentRepository.findByEmail(forgotPasswordDto.getEmail());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            String token = randomNumberGenerator.generateToken();

            return new ForgotPasswordResponseDto (
                    "Token send Successfully",
                    student.getEmail(),
                    token
            );

        }

        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(forgotPasswordDto.getEmail());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();

            String token = randomNumberGenerator.generateToken();

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
