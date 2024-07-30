package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "admission_number_tracker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admission_number_id", length = 11)
    private long admissionNumberId;

    @Nullable
    @Column(name = "recent_admission_number", length = 45)
    private String recentAdmissionNumber;

}
