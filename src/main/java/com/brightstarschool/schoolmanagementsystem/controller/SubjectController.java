package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.SubjectDTO;
import com.brightstarschool.schoolmanagementsystem.dto.SubjectSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/subjects")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(path = "/add-subject")
    public ResponseEntity<String> addSubjects(@RequestBody SubjectSaveDTO subjectSaveDTO)
    {
        String response = subjectService.addSubject(subjectSaveDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-all-subjects")
    public ResponseEntity<List<SubjectDTO>> getAllSubjects()
    {
        List<SubjectDTO> subjects = subjectService.getAllSubjects();

        return ResponseEntity.ok(subjects);
    }
}
