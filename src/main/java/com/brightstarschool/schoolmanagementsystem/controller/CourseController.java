package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.CourseService;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/add-courses")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO)
    {
        String courseName = courseService.addCourse(courseSaveDTO);
        return "Course created successfully. \nCourse Name: " + courseName;
    };

    @GetMapping(path = "/view-all-courses")
    public List<CourseDTO> getAllCourses()
    {
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return allCourses;
    };

    @PutMapping(path = "/update-course/{id}")
    public String updateCourse(@PathVariable("id") long id, @RequestBody CourseUpdateDTO courseUpdateDTO) {
        String updatedCourse = courseService.updateCourse(id, courseUpdateDTO);
        return updatedCourse;
    }

    @DeleteMapping(path = "/delete-course/{id}")
    public String deleteCourse(@PathVariable("id") long id) {
        boolean deleteCourse = courseService.deleteCourse(id);
        if (deleteCourse) {
            return "Course deleted successfully";
        } else {
            return "Course ID not found";
        }
    }


}
