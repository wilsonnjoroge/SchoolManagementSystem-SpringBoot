package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.BatchService;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batches")
public class BatchController {
    private BatchService batchService;

    @Autowired
    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping(path = "/add-batches")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO)
    {
        String batchName = batchService.addBatch(batchSaveDTO);
        return "Batch created successfully. \nBatch Name: " + batchName;
    };

    @GetMapping(path = "/view-all-batches")
    public List<BatchDTO> getAllBatches()
    {
        List<BatchDTO> allBatches = batchService.getAllBatches();
        return allBatches;
    };

    @PutMapping(path = "/update-batch/{id}")
    public String updateBatch(@PathVariable("id") long id, @RequestBody BatchUpdateDTO batchUpdateDTO) {
        String updatedBatch = batchService.updateBatch(id, batchUpdateDTO);
        return updatedBatch;
    }

    @DeleteMapping(path = "/delete-batch/{id}")
    public String deleteBatch(@PathVariable("id") long id) {
        boolean deleteBatch = batchService.deleteBatch(id);
        if (deleteBatch) {
            return "Batch deleted successfully";
        } else {
            return "Batch ID not found";
        }
    }

}
