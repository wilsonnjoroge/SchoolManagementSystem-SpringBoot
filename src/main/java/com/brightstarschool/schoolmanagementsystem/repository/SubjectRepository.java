package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectCode(long subjectCode);

    Optional<Subject> findBySubjectName(String subjectName);

}
