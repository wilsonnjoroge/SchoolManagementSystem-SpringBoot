package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.Utils.NumberGenerator;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.Utils.EmailsManagement;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationStudent;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import java.util.Optional;

@Service
public class AuthenticationStudentServiceImplementation implements AuthenticationStudent {
    private StudentRepository studentRepository;
    private PasswordEncoder  passwordEncoder;
    private EmailsManagement emailsManagement;
    private NumberGenerator numberGenerator;

    @Autowired
    public AuthenticationStudentServiceImplementation(StudentRepository studentRepository,
                                                      PasswordEncoder passwordEncoder,
                                                      EmailsManagement emailsManagement,
                                                      NumberGenerator numberGenerator) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailsManagement = emailsManagement;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        try {

            Optional<Student> studentIdExist = studentRepository.findByIdNumber(studentSaveDTO.getIdNumber());

            if(studentIdExist.isPresent())
            {
                return ("Student with id: " + studentSaveDTO.getIdNumber() + " already exists!!");
            };

            Optional<Student> studentEmailExist = studentRepository.findByEmail(studentSaveDTO.getEmail());
            if(studentEmailExist.isPresent())
            {
                return ( "Student with email: " + studentSaveDTO.getEmail() + " already exists!!");
            }

            String encodedPassword = passwordEncoder.encode(studentSaveDTO.getPassword());
            String verificationToken = RandomStringUtils.randomAlphanumeric(32);

            String admissionNumber = numberGenerator.generateSequentialNumber();

            Student student = new Student(
                    admissionNumber,
                    studentSaveDTO.getName(),
                    studentSaveDTO.getAdress(),
                    studentSaveDTO.getPhoneNumber(),
                    studentSaveDTO.getEmail(),
                    studentSaveDTO.getIdNumber(),
                    encodedPassword,
                    "",
                    "",
                    verificationToken,
                    false,
                    false
            );

            studentRepository.save(student);

            String emailBody = "Dear " + studentSaveDTO.getName() + ", Admission Number: "+ admissionNumber + ",\nWelcome to Bright Star School. We are pleased to have you aboard.\nPlease verify your email by clicking the link below:\n" +
                    "http://localhost:5555/api/v1/students/verify-email?token=" + verificationToken;

            emailsManagement.sendEmail(studentSaveDTO.getEmail(), "Registration Successful", emailBody);

            return student.getName();

        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean verifyEmail(String token) {
        Optional<Student> studentOptional = studentRepository.findByVerificationToken(token);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setEmailVerified(true);
            student.setVerificationToken(null);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

}
