package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", length = 11)
    private long teacherId;

    @NotNull
    @Column(name = "teacher_name", length = 45)
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

    // Relationship with Subjects
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subjects;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role roles;

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


    public Teacher() {
    }

    public Teacher(long teacherId,
                   String name,
                   String adress,
                   String email,
                   long phoneNumber,
                   long idNumber,
                   Subject subjects,
                   Role roles,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.teacherId = teacherId;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.subjects = subjects;
        this.roles = roles;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
    }

    public Teacher(String name,
                   String adress,
                   String email,
                   long phoneNumber,
                   long idNumber,
                   Subject subjects,
                   Role roles,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.subjects = subjects;
        this.roles = roles;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
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

    public Subject getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber=" + idNumber +
                ", subjects=" + subjects +
                ", roles=" + roles +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
