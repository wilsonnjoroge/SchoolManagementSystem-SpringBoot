package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.FeePerTermRepository;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;
    private FeePerTermRepository feePerTermRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository,
                                        FeePerTermRepository feePerTermRepository) {
        this.studentRepository = studentRepository;
        this.feePerTermRepository = feePerTermRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudent = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student student : getStudent)
        {
            StudentDTO studentDTO = new StudentDTO
                    (
                            student.getStudentId(),
                            student.getAdmissionNumber(),
                            student.getName(),
                            student.getAdress(),
                            student.getPhoneNumber(),
                            student.getEmail(),
                            student.getIdNumber(),
                            student.getDormitory(),
                            student.getCurrentTerm(),
                            student.getTotalFeeBilled(),
                            student.getTotalPaidFee(),
                            student.getFeeBalance(),
                            student.getAccessToken(),
                            student.getResetToken(),
                            student.isEmailVerified(),
                            student.isDeleted()
                    );
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }


    @Override
    public String updateStudent(long id, StudentUpdateDTO studentUpdateDTO) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.getById(id);

            if (studentUpdateDTO.getName() != null) {
                student.setName(studentUpdateDTO.getName());
            }
            if (studentUpdateDTO.getAdress() != null) {
                student.setAdress(studentUpdateDTO.getAdress());
            }
            if (studentUpdateDTO.getPhoneNumber() != 0) {
                student.setPhoneNumber(studentUpdateDTO.getPhoneNumber());
            }
            if (studentUpdateDTO.getEmail() != null) {
                student.setEmail(studentUpdateDTO.getEmail());
            }
            if (studentUpdateDTO.getIdNumber() != 0) {
                student.setIdNumber(studentUpdateDTO.getIdNumber());
            }

            // check if the studentUpdateDTO.getCurrentTermId() is not zero and not the current term already assigned to the student
            if (studentUpdateDTO.getCurrentTermId() != 0 && studentUpdateDTO.getCurrentTermId() != student.getCurrentTerm().getId()) {
                Optional<FeesPerTerm> currentTermOptional = feePerTermRepository.findById(studentUpdateDTO.getCurrentTermId());
                if (currentTermOptional.isPresent()) {
                    FeesPerTerm currentTerm = currentTermOptional.get();
                    student.setCurrentTerm(currentTerm);

                    // Update the fee balance
                    long newFeeBilled = student.getFeeBalance() + currentTerm.getFeeCharged();
                    student.setTotalFeeBilled(newFeeBilled);
                    student.setFeeBalance(newFeeBilled - student.getTotalPaidFee());
                } else {
                    System.out.println("\nTerm ID not Found");
                    return "Term ID not Found";
                }
            }

            studentRepository.save(student);

            return "Student details updated Successfully";

        } else {

            return "Student ID not Found";
        }
    }



    @Override
    public boolean deleteStudent(long id) {
        if (studentRepository.existsById(id)) {

            Student student = studentRepository.getById(id);
            student.setDeleted(true);

            studentRepository.save(student);
            return true;

        } else {
            System.out.println("\nStudent ID not found");
            return false;
        }
    }

}
