package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.StreamSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.implementation.StreamServiceImplementation;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.StreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/streams")
public class StreamController {

    private StreamServiceImplementation streamServiceImplementation;

    public StreamController(StreamServiceImplementation streamServiceImplementation) {
        this.streamServiceImplementation = streamServiceImplementation;
    }

    @PostMapping(path = "/add-stream")
    public ResponseEntity<String> addStream(@RequestBody StreamSaveDTO streamSaveDTO)
    {
        String response = streamServiceImplementation.addStream(streamSaveDTO);

        return ResponseEntity.ok(response);
    }
}
