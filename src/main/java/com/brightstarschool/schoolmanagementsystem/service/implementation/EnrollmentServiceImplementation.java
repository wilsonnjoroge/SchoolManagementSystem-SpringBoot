package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.CourseDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.EnrollmentUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Batch;
import com.brightstarschool.schoolmanagementsystem.entity.Course;
import com.brightstarschool.schoolmanagementsystem.entity.Enrollment;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.BatchRepository;
import com.brightstarschool.schoolmanagementsystem.repository.CourseRepository;
import com.brightstarschool.schoolmanagementsystem.repository.EnrollmentRepository;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImplementation implements EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private BatchRepository batchRepository;

    @Autowired
    public EnrollmentServiceImplementation(EnrollmentRepository enrollmentRepository,
                                           StudentRepository studentRepository,
                                           CourseRepository courseRepository,
                                           BatchRepository batchRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        try {
            // Retrieve the student by their ID
            Optional<Student> studentOptional = studentRepository.findById(enrollmentSaveDTO.getStudentId());
            if (!studentOptional.isPresent()) {
                return "Student Not Found";
            }

            // Retrieve the batch by their ID
            Optional<Batch> batchOptional = batchRepository.findById(enrollmentSaveDTO.getBatchId());
            if (!batchOptional.isPresent()) {
                return "Batch Not Found";
            }

            Student student = studentOptional.get();
            Batch batch = batchOptional.get();

            Enrollment enrollment = new Enrollment(
                    student,
                    batch,
                    enrollmentSaveDTO.getJoinDate(),
                    enrollmentSaveDTO.getFee()
            );

            enrollmentRepository.save(enrollment);
            System.out.println("\nMessage: Enrollment Saved Successfully");

            return "Enrollment created successfully. Enrollment Join Date: " + enrollment.getJoinDate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }


    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollmentId(),
                    enrollment.getStudent(),
                    //enrollment.getBatch(),
                    enrollment.getJoinDate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }

        return enrollmentDTOList;
    }

    @Override
    public String updateEnrollment(long id, EnrollmentUpdateDTO enrollmentUpdateDTO) {
        try {
            // Retrieve the enrollment by its ID
            Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(id);
            if (!enrollmentOptional.isPresent()) {
                return "Enrollment Not Found";
            }

            Enrollment enrollment = enrollmentOptional.get();

            // Retrieve the student and batch by their IDs from the DTO
            Optional<Student> studentOptional = studentRepository.findById(enrollmentUpdateDTO.getStudent().getStudentId());
            if (!studentOptional.isPresent()) {
                return "Student Not Found";
            }

            Optional<Batch> batchOptional = batchRepository.findById(enrollmentUpdateDTO.getBatch().getBatchId());
            if (!batchOptional.isPresent()) {
                return "Batch Not Found";
            }

            Student student = studentOptional.get();
            Batch batch = batchOptional.get();

            // Update the enrollment details
            enrollment.setStudent(student);
            enrollment.setBatch(batch);
            enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
            enrollment.setFee(enrollmentUpdateDTO.getFee());

            // Save the updated enrollment back to the database
            enrollmentRepository.save(enrollment);

            System.out.println("\nMessage: Enrollment Updated Successfully");

            return "Enrollment updated successfully. Enrollment ID: " + enrollment.getEnrollmentId();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean deleteEnrollment(long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            System.out.println("\nEnrollment deleted successfully");
            return true;
        } else {
            System.out.println("\nEnrollment ID not found");
            return false;
        }
    }
}


