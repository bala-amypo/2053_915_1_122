package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfluencerController {

    InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    public Influencer createInfluencer(Influencer inf) {
        return service.createInfluencer(inf);
    }

    public List<Influencer> getAllInfluencers() {
        return service.getAllInfluencers();
    }

    public Influencer getInfluencer(Long id) {
        return service.getInfluencerById(id);
    }
}
