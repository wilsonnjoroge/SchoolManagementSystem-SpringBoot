package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.BatchSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Enrollment;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.BatchService;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/enrollments")
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/add-enrollments")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO)
    {
        String results = enrollmentService.addEnrollment(enrollmentSaveDTO);
        return results;
    };

    @GetMapping(path = "/view-all-enrollments")
    public List<EnrollmentDTO> getAllEnrollments()
    {
        List<EnrollmentDTO> results = enrollmentService.getAllEnrollments();
        return results;
    }

    @PutMapping("/update-enrollment/{id}")
    public String updateEnrollments(@PathVariable("id")long id, EnrollmentUpdateDTO enrollmentUpdateDTO)
    {
        String results = enrollmentService.updateEnrollment(id,enrollmentUpdateDTO);
        return results;

    };

    @DeleteMapping(path = "/delete-enrollment/{id}")
    public String deleteEnrollment(@PathVariable("id") long id) {
        boolean deleteEnrollment = enrollmentService.deleteEnrollment(id);
        if (deleteEnrollment) {
            return "enrollment deleted successfully";
        } else {
            return "Course ID not found";
        }
    }
}
