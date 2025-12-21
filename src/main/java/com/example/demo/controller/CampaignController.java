package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    public Campaign updateCampaign(Long id, Campaign c) {
        return service.updateCampaign(id, c);
    }

    public Campaign getCampaign(Long id) {
        return service.getCampaignById(id);
    }

    public List<Campaign> getAllCampaigns() {
        return service.getAllCampaigns();
    }
}
