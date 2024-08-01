package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import com.brightstarschool.schoolmanagementsystem.repository.FeePerTermRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.FeePerTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeePerTermServiceImplementation implements FeePerTermService {

    private FeePerTermRepository feePerTermRepository;

    @Autowired
    public FeePerTermServiceImplementation(FeePerTermRepository feePerTermRepository) {
        this.feePerTermRepository = feePerTermRepository;
    }

    @Override
    public String addFeePerTerm(FeesPerTermSaveDTO feesPerTermSaveDTO) {

        FeesPerTerm feesPerTerm = new FeesPerTerm(
                feesPerTermSaveDTO.getTerm(),
                feesPerTermSaveDTO.getTermStartDate(),
                feesPerTermSaveDTO.getTermEndDate(),
                feesPerTermSaveDTO.getFeeCharged()
        );

        feePerTermRepository.save(feesPerTerm);

        return "Fee for Term: " + feesPerTermSaveDTO.getTerm() + " added successfully";
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
