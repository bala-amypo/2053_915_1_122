package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable Long id,
                                                   @RequestBody Campaign c) {
        return new ResponseEntity<>(
                service.updateCampaign(id, c),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getCampaignById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return new ResponseEntity<>(
                service.getAllCampaigns(),
                HttpStatus.OK
        );
    }
}
