package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.entity.Teacher;
import com.brightstarschool.schoolmanagementsystem.repository.TeacherRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImplementation implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        try {
            Teacher teacher = new Teacher(
                    teacherSaveDTO.getTeacherName(),
                    teacherSaveDTO.getAdress(),
                    teacherSaveDTO.getPhoneNumber()
            );

            teacherRepository.save(teacher);
            System.out.println("\nMessage: Teacher Saved Successfully");

            return teacher.getTeacherName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

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
                            teacher.getTeacherName(),
                            teacher.getAdress(),
                            teacher.getPhoneNumber()
                    );
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    @Override
    public String updateTeacher(long id, TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepository.existsById(id)) {
            Teacher teacher = teacherRepository.getById(id);
            teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
            teacher.setAdress(teacherUpdateDTO.getAdress());
            teacher.setPhoneNumber(teacherUpdateDTO.getPhoneNumber());

            teacherRepository.save(teacher);
            System.out.println("\nTeacher details updated Successfully");
            return "Teacher details updated Successfully";
        } else {
            System.out.println("\nTeacher ID not Found");
            return "Teacher ID not Found";
        }
    }

    @Override
    public boolean deleteTeacher(long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            System.out.println("\nTeacher deleted successfully");
            return true;
        } else {
            System.out.println("\nTeacher ID not found");
            return false;
        }
    }
}
