package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StreamDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.repository.StreamRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StreamService;

import java.util.List;

public class StreamServiceImplementation implements StreamService {
    @Override
    public String addStream(StreamSaveDTO streamSaveDTO) {
        return null;
    }

    @Override
    public List<StreamDTO> getAllStreams() {
        return null;
    }

    @Override
    public String updateStream(long streamId, StreamUpdateDTO streamUpdateDTO) {
        return null;
    }

    @Override
    public Boolean deleteStream(long streamId) {
        return null;
    }
}
