package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.StreamDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamUpdateDTO;

import java.util.List;

public interface StreamService {
    String addStream(StreamSaveDTO streamSaveDTO);

    List<StreamDTO> getAllStreams();

    String updateStream(long streamId, StreamUpdateDTO streamUpdateDTO);

    Boolean deleteStream(long streamId);
}
