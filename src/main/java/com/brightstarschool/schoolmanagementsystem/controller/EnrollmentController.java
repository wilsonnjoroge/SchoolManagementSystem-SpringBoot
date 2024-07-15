package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.BatchSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.BatchService;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/add-enrollments")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO)
    {
        String enrollmentName = enrollmentService.addEnrollment(enrollmentSaveDTO);
        return "Enrollment created successfully. \nEnrollment Name: " + enrollmentName;
    };
}
