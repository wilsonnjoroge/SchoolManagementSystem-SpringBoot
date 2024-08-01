package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.FeePerTermService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
