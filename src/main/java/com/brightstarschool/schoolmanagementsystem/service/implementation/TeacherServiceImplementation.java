package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.entity.Subject;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.SubjectRepository;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplementation implements TeacherService {
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

    @Autowired
    public TeacherServiceImplementation(TeacherRepository teacherRepository,
                                        SubjectRepository subjectRepository)
    {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> getTeacher = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for(Teacher teacher : getTeacher)
        {
            TeacherDTO teacherDTO = new TeacherDTO
                    (
                            teacher.getTeacherId(),
                            teacher.getName(),
                            teacher.getAdress(),
                            teacher.getPhoneNumber(),
                            teacher.getEmail(),
                            teacher.getIdNumber(),
                            teacher.getSubjects(),
                            teacher.getAccessToken(),
                            teacher.getResetToken(),
                            teacher.isEmailVerified(),
                            teacher.isDeleted()
                    );
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    @Override
    public String updateTeacher(long id, TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepository.existsById(id)) {
            Teacher teacher = teacherRepository.getById(id);

            if (teacherUpdateDTO.getTeacherName() != null) {
                teacher.setName(teacherUpdateDTO.getTeacherName());
            }
            if (teacherUpdateDTO.getAdress() != null) {
                teacher.setAdress(teacherUpdateDTO.getAdress());
            }
            if (teacherUpdateDTO.getPhoneNumber() != 0) {
                teacher.setPhoneNumber(teacherUpdateDTO.getPhoneNumber());
            }
            if (teacherUpdateDTO.getEmail() != null) {
                teacher.setEmail(teacherUpdateDTO.getEmail());
            }
            if (teacherUpdateDTO.getIdNumber() != 0) {
                teacher.setIdNumber(teacherUpdateDTO.getIdNumber());
            }

//            if (teacherUpdateDTO.getSubjectIds() != 0) {
//                Subject subject = subjectRepository.findBySubjectId(teacherUpdateDTO.getSubjectIds());
//                teacher.setSubjects(subject);
//            }

            teacherRepository.save(teacher);
            return "Teacher details updated Successfully";

        } else {
            System.out.println("\nTeacher ID not Found");
            return "Teacher ID not Found";
        }
    }

    @Override
    public boolean deleteTeacher(long id) {
        if (teacherRepository.existsById(id)) {
            Teacher teacher = teacherRepository.getById(id);
            teacher.setDeleted(true);

            teacherRepository.save(teacher);
            return true;
        } else {
            System.out.println("\nTeacher ID not found");
            return false;
        }
    }
}
