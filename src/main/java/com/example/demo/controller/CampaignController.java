package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    // POST – create campaign
    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaign;
    }

    // GET – get campaign by id
    @GetMapping("/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    // PUT – update campaign
    @PutMapping("/{id}")
    public Campaign updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }
}
