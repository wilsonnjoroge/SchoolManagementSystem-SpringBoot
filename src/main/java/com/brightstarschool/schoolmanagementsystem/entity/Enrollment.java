package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollment_id")
    private long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @Column(name = "join_date", length = 45)
    private String joinDate;

    @Column(name = "fee", length = 12)
    private int fee;

    public Enrollment() {
    }

    public Enrollment(long enrollmentId, Student student, Batch batch, String joinDate, int fee) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public Enrollment(Student student, Batch batch, String joinDate, int fee) {
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", student=" + student +
                ", batch=" + batch +
                ", joinDate='" + joinDate + '\'' +
                ", fee=" + fee +
                '}';
    }
}
