package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.StreamDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StreamUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.service.implementation.StreamServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/streams")
public class StreamController {

    private StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @PostMapping(path = "/add-stream")
    public ResponseEntity<String> addStream(@RequestBody StreamSaveDTO streamSaveDTO)
    {
        String response = streamService.addStream(streamSaveDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-all-streams")
    public ResponseEntity<List<StreamDTO>> getAllStreams()
    {
       List<StreamDTO> streams = streamService.getAllStreams();

       return ResponseEntity.ok(streams);
    }

    @PutMapping("/update-stream/{id}")
    public ResponseEntity<String> updateStream(@PathVariable("id") long id, @RequestBody StreamUpdateDTO streamUpdateDTO)
    {
        String response = streamService.updateStream(id, streamUpdateDTO);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete-stream/{id}")
    public String deleteStream(@PathVariable("id") long id) {
        boolean deleteStream = streamService.deleteStream(id);
        if (deleteStream) {
            return "Stream deleted successfully";
        } else {
            return "Stream ID not found";
        }
    }
}
