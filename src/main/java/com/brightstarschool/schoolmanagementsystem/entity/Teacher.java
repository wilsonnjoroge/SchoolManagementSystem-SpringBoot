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

    @NotNull
    @Column(name = "phoneNumber", length = 12)
    private String phoneNumber;

    public Teacher() {
    }

    public Teacher(long teacherId, String teacherName, String adress, String phoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public Teacher(String teacherName, String adress, String phoneNumber) {
        this.teacherName = teacherName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
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


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
