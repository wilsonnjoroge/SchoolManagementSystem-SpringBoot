package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.service.implementation.AuthenticationTeacherServiceImpplementation;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private TeacherService teacherService;
    private AuthenticationTeacherServiceImpplementation authenticationTeacherServiceImpplementation;

    @Autowired
    public TeacherController(TeacherService teacherService,
                             AuthenticationTeacherServiceImpplementation authenticationTeacherServiceImpplementation) {
        this.teacherService = teacherService;
        this.authenticationTeacherServiceImpplementation = authenticationTeacherServiceImpplementation;
    }

    @PostMapping(path = "/add-teachers")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        String teacherName = authenticationTeacherServiceImpplementation.addTeacher(teacherSaveDTO);
        return "Name: " + teacherName;
    };

    @GetMapping(path = "/view-all-teachers")
    public List<TeacherDTO> getAllTeachers()
    {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    };

    @PutMapping(path = "/update-teacher/{id}")
    public String updateTeacher(@PathVariable("id") long id, @RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        String updatedTeacher = teacherService.updateTeacher(id, teacherUpdateDTO);
        return updatedTeacher;
    }

    @DeleteMapping(path = "/delete-teacher/{id}")
    public String deleteTeacher(@PathVariable("id") long id) {
        boolean deleteTeacher = teacherService.deleteTeacher(id);
        if (deleteTeacher) {
            return "Teacher deleted successfully";
        } else {
            return "Teacher ID not found";
        }
    }
}
