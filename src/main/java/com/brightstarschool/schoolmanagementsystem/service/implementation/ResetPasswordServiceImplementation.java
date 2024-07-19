package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.ResetPasswordDTO;
import com.brightstarschool.schoolmanagementsystem.dto.ResetPasswordResponseDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.Utils.TokenHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResetPasswordServiceImplementation {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TokenHasher tokenHasher;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResetPasswordResponseDTO resetPassword(ResetPasswordDTO resetPasswordDTO) {

        // Validate the email and reset code for Student
        Optional<Student> studentOptional = studentRepository.findByEmail(resetPasswordDTO.getEmail());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            // Validate the reset token
            boolean isValidToken = tokenHasher.validateResetToken(student.getResetToken(), resetPasswordDTO.getResetCode());
            if (isValidToken) {
                String hashedPassword = passwordEncoder.encode(resetPasswordDTO.getNewPassword());
                student.setPassword(hashedPassword);

                student.setResetToken(null);
                studentRepository.save(student);

                return new ResetPasswordResponseDTO(
                        "Password reset successfully",
                        student.getEmail()
                );
            }

            return new ResetPasswordResponseDTO(
                    "Invalid reset token",
                    null
            );
        }

        // Validate the email and reset code for Teacher
        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(resetPasswordDTO.getEmail());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();

            // Validate the reset token
            boolean isValidToken = tokenHasher.validateResetToken(teacher.getResetToken(), resetPasswordDTO.getResetCode());
            if (isValidToken) {
                String hashedPassword = passwordEncoder.encode(resetPasswordDTO.getNewPassword());
                teacher.setPassword(hashedPassword);

                teacher.setResetToken(null);
                teacherRepository.save(teacher);

                return new ResetPasswordResponseDTO(
                        "Password reset successfully",
                        teacher.getEmail()
                );
            }

            return new ResetPasswordResponseDTO(
                    "Invalid reset token",
                    null
            );
        }

        return new ResetPasswordResponseDTO(
                "Email not found",
                null
        );
    }
}
