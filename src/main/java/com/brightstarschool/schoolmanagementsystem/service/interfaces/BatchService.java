package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.*;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    String updateBatch(long id, BatchUpdateDTO batchUpdateDTO);

    boolean deleteBatch(long id);
}
