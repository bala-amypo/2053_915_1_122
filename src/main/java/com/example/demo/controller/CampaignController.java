package com.example.demo.controller;

import com.example.demo.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {
    @Autowired
    CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public Campaign updateCampaign(@PathVariable Long id,@RequestBody Campaign c) {
        return service.updateCampaign(id, c);
    }

    @GetMapping("/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return service.getCampaignById(id);
    }

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return service.getAllCampaigns();
    }
}
