package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
                   String password,
                   String resetToken,
                   String verificationToken,
                   String accessToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.teacherId = teacherId;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.password = password;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.accessToken = accessToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
    }

    public Teacher(String name,
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
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.password = password;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.accessToken = accessToken;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber=" + idNumber +
                ", password='" + password + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", isDeleted=" + isDeleted +
                '}';
    }

}
