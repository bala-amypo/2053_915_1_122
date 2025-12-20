package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PutMapping("/campaigns/{id}")
    public Campaign updateCampaign(@PathVariable Long id,
                                   @RequestBody Campaign c) {
        return service.updateCampaign(id, c);
    }

    @GetMapping("/campaigns/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return service.getCampaignById(id);
    }

    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns() {
        return service.getAllCampaigns();
    }
}
