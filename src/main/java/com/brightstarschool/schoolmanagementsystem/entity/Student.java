package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "admission_number")
    private String admissionNumber;

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

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream stream;

    @ManyToOne
    @JoinColumn(name = "dormitory_id")
    private Dormitory dormitory;

    @ManyToOne
    @JoinColumn(name = "current_term_id")
    private FeesPerTerm currentTerm;

    @NotNull
    @Column(name = "total_fees_billed")
    private long totalFeeBilled;

    @NotNull
    @Column(name = "paid_fees")
    private long totalPaidFee;

    @NotNull
    @Column(name = "fee_balance")
    private long feeBalance;

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

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments;


    public Student() {
    }

    public Student(long studentId,
                   String admissionNumber,
                   String name,
                   String adress,
                   String email,
                   long phoneNumber,
                   long idNumber,
                   Stream stream,
                   Dormitory dormitory,
                   FeesPerTerm currentTerm,
                   long totalFeeBilled,
                   long totalPaidFee,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted,
                   Set<Enrollment> enrollments) {
        this.studentId = studentId;
        this.admissionNumber = admissionNumber;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.stream = stream;
        this.dormitory = dormitory;
        this.currentTerm = currentTerm;
        this.totalFeeBilled = totalFeeBilled;
        this.totalPaidFee = totalPaidFee;
        this.feeBalance  = totalFeeBilled - totalPaidFee;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
        this.enrollments = enrollments;
    }

    public Student(String admissionNumber,
                   String name,
                   String adress,
                   String email,
                   long phoneNumber,
                   long idNumber,
                   Stream stream,
                   Dormitory dormitory,
                   FeesPerTerm currentTerm,
                   long totalFeeBilled,
                   long totalPaidFee,
                   String password,
                   String accessToken,
                   String resetToken,
                   String verificationToken,
                   boolean isEmailVerified,
                   boolean isDeleted) {
        this.admissionNumber = admissionNumber;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.stream = stream;
        this.dormitory = dormitory;
        this.currentTerm = currentTerm;
        this.totalFeeBilled = totalFeeBilled;
        this.totalPaidFee = totalPaidFee;
        this.feeBalance  = totalFeeBilled - totalPaidFee;
        this.password = password;
        this.accessToken = accessToken;
        this.resetToken = resetToken;
        this.verificationToken = verificationToken;
        this.isEmailVerified = isEmailVerified;
        this.isDeleted = isDeleted;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
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

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public long getTotalFeeBilled() {
        return totalFeeBilled;
    }

    public void setTotalFeeBilled(long totalFeeBilled) {
        this.totalFeeBilled = totalFeeBilled;
    }

    public long getTotalPaidFee() {
        return totalPaidFee;
    }

    public void setTotalPaidFee(long totalPaidFee) {
        this.totalPaidFee = totalPaidFee;
    }

    public long getFeeBalance() {
        return feeBalance;
    }

    public void setFeeBalance(long feeBalance) {
        this.feeBalance = feeBalance;
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

    public FeesPerTerm getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(FeesPerTerm currentTerm) {
        this.currentTerm = currentTerm;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", admissionNumber='" + admissionNumber + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber=" + idNumber +
                ", stream=" + stream +
                ", dormitory=" + dormitory +
                ", currentTerm=" + currentTerm +
                ", totalFeeBilled=" + totalFeeBilled +
                ", totalPaidFee=" + totalPaidFee +
                ", feeBalance=" + feeBalance +
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
