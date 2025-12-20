package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer inf) {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencer(@PathVariable Long id) {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }
}
