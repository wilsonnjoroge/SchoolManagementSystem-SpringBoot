package com.brightstarschool.schoolmanagementsystem.service.interfaces;


import com.brightstarschool.schoolmanagementsystem.dto.SubjectDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectUpdateDTO;

import javax.security.auth.Subject;
import java.util.List;

public interface SubjectService {
    String addSubject(SubjectSaveDTO subjectSaveDTO);

    List<SubjectDTO> getAllSubjects();

    String updateSubject(long id, SubjectUpdateDTO subjectUpdateDTO);

    boolean deleteSubject(long id);
}
