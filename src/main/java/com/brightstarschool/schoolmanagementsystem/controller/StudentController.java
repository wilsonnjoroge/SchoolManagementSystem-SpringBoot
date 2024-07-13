package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add-students")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        String stname = studentService.addStudent(studentSaveDTO);
        return stname;
    };

}
