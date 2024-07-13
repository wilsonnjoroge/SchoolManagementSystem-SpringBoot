package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(path = "/add-students")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        String studentName = studentService.addStudent(studentSaveDTO);
        return studentName;
    };

    @GetMapping(path = "/view-all-students")
    public List<StudentDTO> getAllStudents()
    {
        List<StudentDTO> allStudents = studentService.getAllStudents();

        return allStudents;

    };

}
