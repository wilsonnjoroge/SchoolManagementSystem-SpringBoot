package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationStudent;
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

            Optional<Student> studentExist = studentRepository.findByIdNumber(studentSaveDTO.getIdNumber());

            if(studentExist.isPresent())
            {
                return ("Student with id: " + studentSaveDTO.getIdNumber() + " already exists!!");

            };

            Student student = new Student(
                    studentSaveDTO.getStudentName(),
                    studentSaveDTO.getAdress(),
                    studentSaveDTO.getPhoneNumber(),
                    studentSaveDTO.getEmail(),
                    studentSaveDTO.getIdNumber()
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
