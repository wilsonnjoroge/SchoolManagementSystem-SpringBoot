package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.DormitoryDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Dormitory;
import com.brightstarschool.schoolmanagementsystem.repository.SubjectRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.SubjectService;
import com.brightstarschool.schoolmanagementsystem.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImplementation implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImplementation(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public String addSubject(SubjectSaveDTO subjectSaveDTO) {
        Optional<Subject> subjectCodeExists = subjectRepository.findBySubjectCode(subjectSaveDTO.getSubjectCode());
        Optional<Subject> subjectNameExists = subjectRepository.findBySubjectName(subjectSaveDTO.getSubjectName());

        if(subjectCodeExists.isPresent())
        {
            return "Subject with that ID already exists";
        }

        if(subjectNameExists.isPresent())
        {
            return "Subject with that Name already exists";
        }

        Subject subject = new Subject
                (
                        subjectSaveDTO.getSubjectCode(),
                        subjectSaveDTO.getSubjectName()
                );

        subjectRepository.save(subject);

        return "Subject created successfully";
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> allSubjects = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        for (Subject subject : allSubjects)
        {
            SubjectDTO subjectDTO = new SubjectDTO
                    (
                            subject.getSubjectId(),
                            subject.getSubjectCode(),
                            subject.getSubjectName()
                    );
            subjectDTOList.add(subjectDTO);
        }

        return subjectDTOList;
    }

    @Override
    public String updateSubject(long id, SubjectUpdateDTO subjectUpdateDTO) {

        if(subjectRepository.existsById(id))
        {
            Subject subject = subjectRepository.getById(id);

            if(subjectUpdateDTO.getSubjectCode() != 0)
            {
                subject.setSubjectCode(subjectUpdateDTO.getSubjectCode());
            }

            if(subjectUpdateDTO.getSubjectName() != null)
            {
                subject.setSubjectName(subjectUpdateDTO.getSubjectName());
            }

            subjectRepository.save(subject);
            return "Subject Details Updated Successfully";

        } else {
            return "Subject with that ID not found";
        }
    }

    @Override
    public boolean deleteSubject(long id) {
        if(subjectRepository.existsById(id))
        {
            subjectRepository.deleteById(id);
            return true;
        } else {
            return  false;
        }
    }
}
