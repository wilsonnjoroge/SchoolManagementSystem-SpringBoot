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

    @DeleteMapping(path = "/delete-role/{id}")
    public String deleteRole(@PathVariable("id") long id) {
        boolean deleteRole = studentService.deleteStudent(id);
        if (deleteRole) {
            return "Role deleted successfully";
        } else {
            return "Role ID not found";
        }
    }


}
