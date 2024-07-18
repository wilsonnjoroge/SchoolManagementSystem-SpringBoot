package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", length = 11)
    private long teacherId;

    @NotNull
    @Column(name = "teacher_name", length = 45)
    private String teacherName;

    @NotNull
    @Column(name = "adress", length = 60)
    private String adress;

    @Column(name = "email", length = 65)
    private String email;
    @NotNull
    @Column(name = "phoneNumber", length = 12)
    private String phoneNumber;

    @NotNull
    @Column(name = "idNumber", length = 12)
    private long idNumber;

    public Teacher() {
    }

    public Teacher(long teacherId, String teacherName, String adress, String phoneNumber, String email, long idNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
    }

    public Teacher(String teacherName, String adress, String phoneNumber, String email, long idNumber) {
        this.teacherName = teacherName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

}
