package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // POST – create influencer
    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    // GET – get influencer by id
    @GetMapping("/{id}")
    public Influencer getInfluencer(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    // PUT – update influencer
    @PutMapping("/{id}")
    public Influencer updateInfluencer(
            @PathVariable Long id,
            @RequestBody Influencer influencer) {
        influencer.setId(id);
        return influencer;
    }
}
