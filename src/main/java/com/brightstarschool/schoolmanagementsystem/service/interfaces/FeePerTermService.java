package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.FeesPerTermUpdateDTO;

import java.util.List;

public interface FeePerTermService {

    String addFeePerTerm(FeesPerTermSaveDTO feesPerTermSaveDTO);

    List<FeesPerTermDTO> getAllFeesPerTerm();

    String updateFeePerTerm(long id, FeesPerTermUpdateDTO feesPerTermUpdateDTO);

    boolean deleteFeePerTerm(long id);

}
