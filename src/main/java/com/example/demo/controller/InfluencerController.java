package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    public ResponseEntity<Influencer> createInfluencer(Influencer inf) {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }

    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Influencer> getInfluencer(Long id) {
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }
}
