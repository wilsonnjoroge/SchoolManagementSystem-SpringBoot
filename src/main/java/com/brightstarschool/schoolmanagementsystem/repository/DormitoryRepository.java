package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
    Optional<Dormitory> findByDormCode(long dormCode);

    Optional<Dormitory> findByDormName(String dormName);
}
