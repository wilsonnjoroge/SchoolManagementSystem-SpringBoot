package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 11)
    private long studentId;

    @Column(name = "student_name", length = 45)
    private String studentName;

    @Column(name = "adress", length = 60)
    private String adress;

    @Column(name = "phoneNumber", length = 12)
    private String phoneNumber;


    public Student() {
    }

    public Student(long studentId, String studentName, String adress, String phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public Student(String studentName, String adress, String phoneNumber) {
        this.studentName = studentName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
