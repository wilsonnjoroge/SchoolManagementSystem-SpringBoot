package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.FeePerTermService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeePerTermServiceImplementation implements FeePerTermService {
    @Override
    public String addFeePerTerm(FeesPerTermSaveDTO feesPerTermSaveDTO) {
        return null;
    }

    @Override
    public List<FeesPerTermDTO> getAllFeesPerTerm() {
        return null;
    }

    @Override
    public String updateFeePerTerm(long id, FeesPerTermUpdateDTO feesPerTermUpdateDTO) {
        return null;
    }

    @Override
    public boolean deleteFeePerTerm(long id) {
        return false;
    }
}
