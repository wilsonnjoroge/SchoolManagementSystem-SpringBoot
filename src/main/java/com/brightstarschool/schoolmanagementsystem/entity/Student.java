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
    private String name;

    @NotNull
    @Column(name = "adress", length = 60)
    private String adress;

    @Column(name = "email", length = 65)
    private String email;

    @NotNull
    @Column(name = "phoneNumber", length = 12)
    private long phoneNumber;

    @NotNull
    @Column(name = "idNumber", length = 12)
    private long idNumber;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "verification_token")
    private String verificationToken;

    @Column(name = "is_email_verified")
    private boolean isEmailVerified;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;


    public Student() {
    }

    public Student(long studentId,
                   String name,
                   String adress,
                   long phoneNumber,
                   String email,
                   long idNumber,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.studentId = studentId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
    }

    public Student(String name,
                   String adress,
                   long phoneNumber,
                   String email,
                   long idNumber,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
        this.enrollments = enrollments;
    }


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber=" + idNumber +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", isDeleted=" + isDeleted +
                ", enrollments=" + enrollments +
                '}';
    }
}
