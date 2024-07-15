package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Entity
@Table(name = "Batches")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "batch_id", length = 11)
    private long batchId;

    @NotNull
    @Column(name = "batch_name", length = 45)
    private String batchName;

    @NotNull
    @Column(name = "start_date", length = 12)
    private String startDate;

    // Many batches contain one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "batch")
    private Set<Enrollment> enrollments;

    public Batch() {
    }

    public Batch(long batchId, String batchName, String startDate, Course course) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public Batch(String batchName, String startDate, Course course) {
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", course=" + course +
                '}';
    }
}
