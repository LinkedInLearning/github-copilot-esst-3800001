package com.linkedinlearning.copilot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/laptimes")
public class LapTimeController {

    private final LapTimeRepository lapTimeRepository;

    public LapTimeController(LapTimeRepository lapTimeRepository) {
        this.lapTimeRepository = lapTimeRepository;
    }

    @GetMapping
    public List<LapTime> getAllLapTimes() { 
        return lapTimeRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<LapTime> addLapTime(@RequestBody LapTime lapTime) {
        LapTime savedLapTime = lapTimeRepository.save(lapTime);
        return new ResponseEntity<>(savedLapTime, HttpStatus.CREATED);
    }

}
