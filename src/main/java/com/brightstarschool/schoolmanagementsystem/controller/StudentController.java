package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.service.implementation.AuthenticationStudentServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/students")
public class StudentController {
    private StudentService studentService;

    private AuthenticationStudentServiceImplementation authenticationStudentServiceImplementation;

    @Autowired
    public StudentController(
            StudentService studentService,
            AuthenticationStudentServiceImplementation authenticationStudentServiceImplementation) {
        this.studentService = studentService;
        this.authenticationStudentServiceImplementation = authenticationStudentServiceImplementation;
    }

    @PostMapping(path = "/add-students")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        String studentName = authenticationStudentServiceImplementation.addStudent(studentSaveDTO);
        return "Name: " + studentName;
    };

    @GetMapping("/verify-email")
    public String verifyEmail(@RequestParam("token") String token) {
        boolean isVerified = authenticationStudentServiceImplementation.verifyEmail(token);
        if (isVerified) {
            return "Email verified successfully!";
        } else {
            return "Invalid or expired verification token.";
        }
    }
    @GetMapping(path = "/view-all-students")
    public List<StudentDTO> getAllStudents()
    {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    };

    @PutMapping(path = "/update-student/{id}")
    public String updateStudent(@PathVariable("id") long id, @RequestBody StudentUpdateDTO studentUpdateDTO) {
        String updatedStudent = studentService.updateStudent(id, studentUpdateDTO);
        return updatedStudent;
    }

    @DeleteMapping(path = "/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        boolean deleteStudent = studentService.deleteStudent(id);
        if (deleteStudent) {
            return "Student deleted successfully";
        } else {
            return "Student ID not found";
        }
    }


}
