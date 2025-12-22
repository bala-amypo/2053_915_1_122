package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfluencerController {

    private final InfluencerService service;
    public InfluencerController(InfluencerService service){
        this.service=service;
    }
    @PostMapping("/influencers")
    public Influencer createInfluencer(@RequestBody Influencer inf) {
        return service.createInfluencer(inf);
    }

    @GetMapping("/influencers")
    public List<Influencer> getAllInfluencers() {
        return service.getAllInfluencers();
    }

    @GetMapping("/influencers/{id}")
    public Influencer getInfluencer(@PathVariable Long id) {
        return service.getInfluencerById(id);
    }
}
