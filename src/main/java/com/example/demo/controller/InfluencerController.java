package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    public ResponseEntity<Influencer> createInfluencer(Influencer i) {
        return ResponseEntity.ok(service.createInfluencer(i));
    }

    public ResponseEntity<Influencer> getInfluencer(Long id) {
        return ResponseEntity.ok(service.getInfluencerById(id));
    }

    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(service.getAllInfluencers());
    }
}