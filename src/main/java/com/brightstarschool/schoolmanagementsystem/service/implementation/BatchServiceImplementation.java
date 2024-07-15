package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.BatchDTO;
import com.brightstarschool.schoolmanagementsystem.dto.BatchSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.BatchUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.dto.CourseDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Batch;
import com.brightstarschool.schoolmanagementsystem.entity.Course;
import com.brightstarschool.schoolmanagementsystem.repository.BatchRepository;
import com.brightstarschool.schoolmanagementsystem.repository.CourseRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceImplementation implements BatchService {
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {
        try {
            Batch batch = new Batch(
                    batchSaveDTO.getBatchName(),
                    batchSaveDTO.getStartDate(),
                    courseRepository.getById(batchSaveDTO.getCourseId())
            );

            batchRepository.save(batch);
            System.out.println("\nMessage: Batch Saved Successfully");

            return batch.getBatchName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatch = batchRepository.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();

        for(Batch batch : getBatch)
        {
            BatchDTO batchDTO = new BatchDTO
                    (
                            batch.getBatchId(),
                            batch.getBatchName(),
                            batch.getCourse(),
                            batch.getStartDate()
                    );
            batchDTOList.add(batchDTO);
        }

        return batchDTOList;
    }

    @Override
    public String updateBatch(long id, BatchUpdateDTO batchUpdateDTO) {
        if (batchRepository.existsById(id)) {
            Batch batch = batchRepository.getById(id);
            batch.setBatchName(batchUpdateDTO.getBatchName());
            batch.setCourse(courseRepository.getById(batchUpdateDTO.getCourseId()));
            batch.setStartDate(batchUpdateDTO.getStartDate());

            batchRepository.save(batch);
            System.out.println("\nBatch details updated Successfully");
            return "Batch details updated Successfully";
        } else {
            System.out.println("\nBatch ID not Found");
            return "Batch ID not Found";
        }
    }

    @Override
    public boolean deleteBatch(long id) {
        if (batchRepository.existsById(id)) {
            batchRepository.deleteById(id);
            System.out.println("\nBatch deleted successfully");
            return true;
        } else {
            System.out.println("\nBatch ID not found");
            return false;
        }
    }
}
