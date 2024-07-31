package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.AdmissionNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmissionTracker extends JpaRepository<AdmissionNumber, Long> {

    Optional<AdmissionNumber> findTopByOrderByAdmissionNumberIdDesc();
}
