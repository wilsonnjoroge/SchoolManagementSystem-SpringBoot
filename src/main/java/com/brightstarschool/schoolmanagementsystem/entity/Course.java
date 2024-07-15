package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", length = 11)
    private long courseId;

    @NotNull
    @Column(name = "course_name", length = 45)
    private String courseName;

    @NotNull
    @Column(name = "syllabus", length = 60)
    private String syllabus;

    @NotNull
    @Column(name = "duration", length = 12)
    private String duration;

    // One course can have many batches
    @OneToMany(mappedBy = "course")
    private Set<Batch> batches;

    public Course() {
    }

    public Course(long courseId, String courseName, String syllabus, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course(String courseName, String syllabus, String duration) {
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }


}
