package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "admission_number_tracker")
public class AdmissionNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admission_number_id")
    private long admissionNumberId;

    @Nullable
    @Column(name = "recent_admission_number", unique = true)
    private String recentAdmissionNumber;
    

    public AdmissionNumber() {}

    public AdmissionNumber(@Nullable String recentAdmissionNumber) {
        this.recentAdmissionNumber = recentAdmissionNumber;
    }

    public long getAdmissionNumberId() {
        return admissionNumberId;
    }

    public void setAdmissionNumberId(long admissionNumberId) {
        this.admissionNumberId = admissionNumberId;
    }

    @Nullable
    public String getRecentAdmissionNumber() {
        return recentAdmissionNumber;
    }

    public void setRecentAdmissionNumber(@Nullable String recentAdmissionNumber) {
        this.recentAdmissionNumber = recentAdmissionNumber;
    }

    @Override
    public String toString() {
        return "AdmissionNumber{" +
                "admissionNumberId=" + admissionNumberId +
                ", recentAdmissionNumber='" + recentAdmissionNumber + '\'' +
                '}';
    }
}
