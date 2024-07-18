package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationStudent;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationStudentServiceImpplementation implements AuthenticationStudent {

    @Autowired
    private StudentRepository studentRepository;

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

            Student student = new Student(
                    studentSaveDTO.getStudentName(),
                    studentSaveDTO.getAdress(),
                    studentSaveDTO.getPhoneNumber(),
                    studentSaveDTO.getEmail(),
                    studentSaveDTO.getIdNumber(),
                    studentSaveDTO.getPassword()
            );

            studentRepository.save(student);
            System.out.println("\nMessage: Student Saved Successfully");

            return student.getStudentName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

}
