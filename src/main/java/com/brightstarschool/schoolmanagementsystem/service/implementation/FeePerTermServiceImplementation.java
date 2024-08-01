package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.FeePerTermRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.FeePerTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<FeesPerTerm> getFees = feePerTermRepository.findAll();
        List<FeesPerTermDTO> feeDTOList = new ArrayList<>();

        for(FeesPerTerm fees : getFees)
        {
            FeesPerTermDTO feesPerTermDTO = new FeesPerTermDTO
                    (
                            fees.getId(),
                            fees.getTerm(),
                            fees.getTermStartDate(),
                            fees.getTermEndDate(),
                            fees.getFeeCharged()
                    );
            feeDTOList.add(feesPerTermDTO);
        }

        return feeDTOList;
    }

    @Override
    public String updateFeePerTerm(long id, FeesPerTermUpdateDTO feesPerTermUpdateDTO) {

        if(feePerTermRepository.existsById(id))
        {
            FeesPerTerm feesPerTerm = feePerTermRepository.getById(id);

            if(feesPerTermUpdateDTO.getTerm() != 0)
            {
                feesPerTerm.setTerm(feesPerTermUpdateDTO.getTerm());
            }

            if(feesPerTermUpdateDTO.getTermStartDate() != null)
            {
                feesPerTerm.setTermStartDate(feesPerTermUpdateDTO.getTermStartDate());
            }

            if(feesPerTermUpdateDTO.getTermEndDate() != null)
            {
                feesPerTerm.setTermEndDate(feesPerTermUpdateDTO.getTermEndDate());
            }

            if(feesPerTermUpdateDTO.getFeeCharged() != 0)
            {
                feesPerTerm.setFeeCharged(feesPerTermUpdateDTO.getFeeCharged());
            }

            feePerTermRepository.save(feesPerTerm);

            return "Fees perTerm updated Successfully";
        } else {
            return "Fees perTerm ID not Found";
        }

    }

    @Override
    public boolean deleteFeePerTerm(long id) {
        return false;
    }
}
