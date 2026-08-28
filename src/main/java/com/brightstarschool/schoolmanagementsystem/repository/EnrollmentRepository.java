package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
