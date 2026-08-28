package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StreamDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Stream;
import com.brightstarschool.schoolmanagementsystem.repository.StreamRepository;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StreamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StreamServiceImplementation implements StreamService {

    private StreamRepository streamRepository;
    private StudentRepository studentRepository;

    public StreamServiceImplementation(StreamRepository streamRepository,
                                       StudentRepository studentRepository) {
        this.streamRepository = streamRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStream(StreamSaveDTO streamSaveDTO) {
        Optional<Stream> streamCodeExists = streamRepository.findByStreamCode(streamSaveDTO.getStreamCode());
        if(streamCodeExists.isPresent())
        {
            return "Stream with that Code already exists";
        }

        Optional<Stream> streamNameExists = streamRepository.findByStreamName(streamSaveDTO.getStreamName());
        if(streamNameExists.isPresent())
        {
            return "Stream with that Name already exists";
        }

        Stream stream = new Stream
                (
                        streamSaveDTO.getStreamCode(),
                        streamSaveDTO.getStreamName()
                );

        streamRepository.save(stream);

        return "Stream saved successfully";
    }

    @Override
    public List<StreamDTO> getAllStreams() {
        List<Stream> getStreams = streamRepository.findAll();
        List<StreamDTO> streamDTOList = new ArrayList<>();

        for(Stream stream : getStreams)
        {
            StreamDTO streamDTO = new StreamDTO
                    (
                            stream.getStreamId(),
                            stream.getStreamCode(),
                            stream.getStreamName()
                    );

            streamDTOList.add(streamDTO);
        }

        return  streamDTOList;
    }

    @Override
    public String updateStream(long streamId, StreamUpdateDTO streamUpdateDTO) {

        if(streamRepository.existsById(streamId))
        {
            Stream stream = streamRepository.getById(streamId);

            if(streamUpdateDTO.getStreamCode() != 0)
            {
                stream.setStreamCode(streamUpdateDTO.getStreamCode());
            }

            if(streamUpdateDTO.getStreamName() != null)
            {
                stream.setStreamName(streamUpdateDTO.getStreamName());
            }

            streamRepository.save(stream);
            return "Stream Details submitted successfully";
        } else {
            return "Stream with that ID no found";
        }
    }

    @Override
    public Boolean deleteStream(long streamId) {
        if(streamRepository.existsById(streamId))
        {
            streamRepository.deleteById(streamId);
            return true;
        }
        return false;
    }

}
