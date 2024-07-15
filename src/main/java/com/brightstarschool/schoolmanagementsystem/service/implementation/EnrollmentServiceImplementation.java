package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Batch;
import com.brightstarschool.schoolmanagementsystem.entity.Enrollment;
import com.brightstarschool.schoolmanagementsystem.repository.BatchRepository;
import com.brightstarschool.schoolmanagementsystem.repository.CourseRepository;
import com.brightstarschool.schoolmanagementsystem.repository.EnrollmentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImplementation implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private BatchRepository batchRepository;


    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        try {
            Enrollment enrollment = new Enrollment(
                    studentRepository.getById(enrollmentSaveDTO.getStudentId()),
                    batchRepository.getById(enrollmentSaveDTO.getEnrollmentId()),
                    enrollmentSaveDTO.getJoinDate(),
                    enrollmentSaveDTO.getFee()

            );

            enrollmentRepository.save(enrollment);
            System.out.println("\nMessage: Enrollment Saved Successfully");

            return enrollment.getJoinDate();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
