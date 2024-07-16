package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.*;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);

    List<EnrollmentDTO> getAllEnrollments();

    String updateEnrollment(long id, EnrollmentUpdateDTO enrollmentUpdateDTO);
}
