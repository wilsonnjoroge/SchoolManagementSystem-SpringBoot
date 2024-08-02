package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dormitories")
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dorm_id")
    private long dormitoryId;

    @Column(name = "dorm_code")
    private long dormCode;

    @Column(name = "dorm_name")
    private String dormName;

    public Dormitory() {
    }

    public Dormitory(long dormitoryId,
                     long dormCode,
                     String dormName) {
        this.dormitoryId = dormitoryId;
        this.dormCode = dormCode;
        this.dormName = dormName;
    }

    public Dormitory(long dormCode,
                     String dormName) {
        this.dormCode = dormCode;
        this.dormName = dormName;
    }

    public long getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(long dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public long getDormCode() {
        return dormCode;
    }

    public void setDormCode(long dormCode) {
        this.dormCode = dormCode;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "dormitoryId=" + dormitoryId +
                ", dormCode=" + dormCode +
                ", dormName='" + dormName + '\'' +
                '}';
    }
}
