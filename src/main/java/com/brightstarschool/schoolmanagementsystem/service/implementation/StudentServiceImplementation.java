package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAdress(),
                studentSaveDTO.getPhoneNumber()
        );

        studentRepository.save(student);
        System.out.println("\nMessage: Student Saved Successfully");

        return student.getStudentName();

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
                            student.getStudentName(),
                            student.getAdress(),
                            student.getPhoneNumber()
                    );
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }
}
