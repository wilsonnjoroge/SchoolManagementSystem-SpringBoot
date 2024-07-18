package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;

import java.util.Set;

@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 11)
    private long studentId;

    @NotNull
    @Column(name = "student_name", length = 45)
    private String studentName;

    @NotNull
    @Column(name = "adress", length = 60)
    private String adress;

    @NotNull
    @Column(name = "phoneNumber", length = 12)
    private String phoneNumber;

    @Column(name = "email", length = 65)
    private String email;

    @NotNull
    @Column(name = "idNumber", length = 12)
    private long idNumber;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;


    public Student() {
    }

    public Student(long studentId, String studentName, String adress, String phoneNumber, String email, long idNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
    }

    public Student(String studentName, String adress, String phoneNumber, String email, long idNumber) {
        this.studentName = studentName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
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

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
