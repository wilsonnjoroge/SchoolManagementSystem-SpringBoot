package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.FeePerTermService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/fees-per-term")
public class FeePerTermController {

    private FeePerTermService feePerTermService;

    public FeePerTermController(FeePerTermService feePerTermService) {
        this.feePerTermService = feePerTermService;
    }

    @PostMapping(path = "/add-term-fee")
    public ResponseEntity<String> createFeePerterm(@RequestBody FeesPerTermSaveDTO feesPerTermSaveDTO) {
        String response = feePerTermService.addFeePerTerm(feesPerTermSaveDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/view-all-fees-per-term")
    public List<FeesPerTermDTO> getAllFeesPerTerm()
    {
        List<FeesPerTermDTO> allFeesPerTerm = feePerTermService.getAllFeesPerTerm();
        return allFeesPerTerm;
    };

}
