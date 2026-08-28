package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.Utils.NumberGenerator;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.Utils.EmailsManagement;
import com.brightstarschool.schoolmanagementsystem.entity.*;
import com.brightstarschool.schoolmanagementsystem.repository.*;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationStudent;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import java.util.Optional;

@Service
public class AuthenticationStudentServiceImplementation implements AuthenticationStudent {
    private StudentRepository studentRepository;
    private PasswordEncoder  passwordEncoder;
    private EmailsManagement emailsManagement;
    private NumberGenerator numberGenerator;
    private AdmissionTracker admissionTracker;
    private FeePerTermRepository feePerTermRepository;
    private DormitoryRepository dormitoryRepository;
    private StreamRepository streamRepository;

    @Autowired
    public AuthenticationStudentServiceImplementation(StudentRepository studentRepository,
                                                      PasswordEncoder passwordEncoder,
                                                      EmailsManagement emailsManagement,
                                                      NumberGenerator numberGenerator,
                                                      AdmissionTracker admissionTracker,
                                                      FeePerTermRepository feePerTermRepository,
                                                      DormitoryRepository dormitoryRepository,
                                                      StreamRepository streamRepository) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailsManagement = emailsManagement;
        this.numberGenerator = numberGenerator;
        this.admissionTracker = admissionTracker;
        this.feePerTermRepository = feePerTermRepository;
        this.dormitoryRepository = dormitoryRepository;
        this.streamRepository = streamRepository;
    }

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        try {

            Optional<Student> studentIdExist = studentRepository.findByIdNumber(studentSaveDTO.getIdNumber());

            if(studentIdExist.isPresent())
            {
                return ("Student with id: " + studentSaveDTO.getIdNumber() + " already exists!!");
            };

            Optional<Student> studentEmailExist = studentRepository.findByEmail(studentSaveDTO.getEmail());
            if(studentEmailExist.isPresent())
            {
                return ( "Student with email: " + studentSaveDTO.getEmail() + " already exists!!");
            }

            String encodedPassword = passwordEncoder.encode(studentSaveDTO.getPassword());
            String verificationToken = RandomStringUtils.randomAlphanumeric(32);

            String admissionNumber = generateUniqueAdmissionNumber();

            // Fetch FeesPerTerm by ID
            Optional<FeesPerTerm> currentTermOptional = feePerTermRepository.findById(studentSaveDTO.getCurrentTermId());
            if (currentTermOptional.isEmpty()) {
                return "Current term with ID " + studentSaveDTO.getCurrentTermId() + " does not exist!";
            }
            FeesPerTerm currentTerm = currentTermOptional.get();
            long totalFeeBilled = currentTerm.getFeeCharged();

            // Fetch Dormitry by ID
            Optional<Dormitory> currentDormitoryOptional = dormitoryRepository.findById(studentSaveDTO.getDormitoryId());
            if(currentDormitoryOptional.isEmpty())
            {
                return "Current dormitory with ID " + studentSaveDTO.getDormitoryId() + " does not exist!";
            }
            Dormitory currentDormitory = currentDormitoryOptional.get();


            Optional<Stream> streamOptionalExists = streamRepository.findById(studentSaveDTO.getStreamId());
            if(!streamOptionalExists.isPresent())
            {
                return "Stream with ID " + studentSaveDTO.getStreamId() + " does not exist!";
            }
            Stream stream = streamOptionalExists.get();

            Student student = new Student(
                    admissionNumber,
                    studentSaveDTO.getName(),
                    studentSaveDTO.getAdress(),
                    studentSaveDTO.getEmail(),
                    studentSaveDTO.getPhoneNumber(),
                    studentSaveDTO.getIdNumber(),
                    stream,
                    currentDormitory,
                    currentTerm,
                    totalFeeBilled,
                    studentSaveDTO.getTotalPaidFee(),
                    encodedPassword,
                    "",
                    "",
                    verificationToken,
                    false,
                    false
            );


            studentRepository.save(student);

            String emailBody = "Dear " + studentSaveDTO.getName() + ", Admission Number: "+ admissionNumber + ",\nWelcome to Bright Star School. We are pleased to have you aboard.\nPlease verify your email by clicking the link below:\n" +
                    "http://localhost:5555/api/v1/students/verify-email?token=" + verificationToken;

            emailsManagement.sendEmail(studentSaveDTO.getEmail(), "Registration Successful", emailBody);

            return student.getName();

        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }


    private String generateUniqueAdmissionNumber() {
        Optional<AdmissionNumber> trackerOptional = admissionTracker.findTopByOrderByAdmissionNumberIdDesc();
        String lastNumberStr = trackerOptional.map(AdmissionNumber::getRecentAdmissionNumber).orElse("BS0000");
        int lastNumber = Integer.parseInt(lastNumberStr.replace("BS", ""));
        int nextNumber = lastNumber + 1;

        String nextAdmissionNumber = numberGenerator.generateSequentialNumber(nextNumber);

        AdmissionNumber tracker = trackerOptional.orElse(new AdmissionNumber());
        tracker.setRecentAdmissionNumber(nextAdmissionNumber);
        admissionTracker.save(tracker);

        return nextAdmissionNumber;
    }


    @Override
    public boolean verifyEmail(String token) {
        Optional<Student> studentOptional = studentRepository.findByVerificationToken(token);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setEmailVerified(true);
            student.setVerificationToken(null);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

}
