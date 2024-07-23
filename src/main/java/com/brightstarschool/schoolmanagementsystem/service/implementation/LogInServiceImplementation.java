package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.LogInResponseDTO;
import com.brightstarschool.schoolmanagementsystem.dto.LoginDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogInServiceImplementation {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LogInServiceImplementation(StudentRepository studentRepository,
                                      TeacherRepository teacherRepository,
                                      PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LogInResponseDTO authenticateUser(LoginDTO loginDTO) {

        Optional<Student> studentOptional = studentRepository.findByEmail(loginDTO.getEmail());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), student.getPassword()) && !student.isDeleted()) {
                return new LogInResponseDTO(
                        "Student login successful!",
                        student.getName(),
                        student.getEmail(),
                        "student-access-token"
                );
            }

            if(student.isDeleted())
            {
                return new LogInResponseDTO(
                        "Account with the below credentials is already deleted",
                        student.getName(),
                        student.getEmail(),
                        ""
                );
            }
        }

        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(loginDTO.getEmail());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), teacher.getPassword()) && !teacher.isDeleted()) {
                return new LogInResponseDTO(
                        "Teacher login successful!",
                        teacher.getName(),
                        teacher.getEmail(),
                        "Teacher-access-token"
                );
            }

            if(teacher.isDeleted())
            {
                return new LogInResponseDTO(
                        "Account with the below credentials is already deleted",
                        teacher.getName(),
                        teacher.getEmail(),
                        ""
                );
            }
        }

        return new LogInResponseDTO(
                "Invalid credentials or user not found!",
                null,
                null,
                null
        );
    }
}
