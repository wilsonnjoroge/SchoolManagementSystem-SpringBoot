package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long > {
    Optional<Teacher> findByIdNumber(long idNumber);

    Optional<Teacher> findByEmail(String email);
}
