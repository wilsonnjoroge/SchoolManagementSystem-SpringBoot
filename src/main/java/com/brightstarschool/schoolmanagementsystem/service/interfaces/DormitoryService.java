package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.*;

import java.util.List;

public interface DormitoryService {
    String addDormitory(DormitorySaveDTO dormitorySaveDTO);

    List<DormitoryDTO> getAllDormitories();

    String updateDormitory(long id, DormitoryUpdateDTO dormitoryUpdateDTO);

    boolean deleteDormitory(long id);
}
