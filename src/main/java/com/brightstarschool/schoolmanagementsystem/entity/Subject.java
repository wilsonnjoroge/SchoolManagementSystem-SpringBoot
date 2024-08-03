package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    public long subjectId;

    @Column(name = "subject_code")
    public long subjectCode;

    @Column(name = "subject_name")
    public String subjectName;


    public Subject() {
    }

    public Subject(long subjectId,
                   long subjectCode,
                   String subjectName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public Subject(long subjectCode,
                   String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(long subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectCode=" + subjectCode +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

}
