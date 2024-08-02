package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.DormitoryDTO;
import com.brightstarschool.schoolmanagementsystem.dto.DormitorySaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.DormitoryUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Dormitory;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/dormitories")
public class DormitoryController {

    private DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService)
    {
        this.dormitoryService = dormitoryService;
    }

    @PostMapping(path = "/add-doritory")
    public ResponseEntity<String> addDormitory(@RequestBody DormitorySaveDTO dormitorySaveDTO)
    {
        String response = dormitoryService.addDormitory(dormitorySaveDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-all-dormitories")
    public ResponseEntity<List<DormitoryDTO>> getAllDormitories()
    {
        List<DormitoryDTO> allDormitories = dormitoryService.getAllDormitories();
        return ResponseEntity.ok(allDormitories);
    }

    @PutMapping(path = "/update-dormitory/{id}")
    public ResponseEntity<String> updateDormitory(@PathVariable("id") long id, @RequestBody DormitoryUpdateDTO dormitoryUpdateDTO)
    {
        String response = dormitoryService.updateDormitory(id, dormitoryUpdateDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete-dormitory/{id}")
    public String deleteDormitory(@PathVariable("id") long id) {
        boolean deleteDormitory = dormitoryService.deleteDormitory(id);
        if (deleteDormitory) {
            return "Dormitory deleted successfully";
        } else {
            return "Dormitory ID not found";
        }
    }
}
