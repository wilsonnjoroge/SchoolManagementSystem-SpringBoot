package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
                            student.getName(),
                            student.getAdress(),
                            student.getPhoneNumber(),
                            student.getEmail(),
                            student.getIdNumber(),
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
            student.setName(studentUpdateDTO.getName());
            student.setAdress(studentUpdateDTO.getAdress());
            student.setPhoneNumber(studentUpdateDTO.getPhoneNumber());
            student.setEmail(studentUpdateDTO.getEmail());
            student.setIdNumber(studentUpdateDTO.getIdNumber());

            studentRepository.save(student);
            System.out.println("\nStudent details updated Successfully");
            return "Student details updated Successfully";
        } else {
            System.out.println("\nStudent ID not Found");
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
