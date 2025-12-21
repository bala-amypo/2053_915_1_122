package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")   // Base URL
public class CampaignController {
    @Autowired
    CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    // UPDATE campaign
    @PutMapping("/{id}")
    public Campaign updateCampaign(@PathVariable Long id,
                                   @RequestBody Campaign c) {
        return service.updateCampaign(id, c);
    }

    // GET campaign by ID
    @GetMapping("/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return service.getCampaignById(id);
    }

    // GET all campaigns
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return service.getAllCampaigns();
    }
}
