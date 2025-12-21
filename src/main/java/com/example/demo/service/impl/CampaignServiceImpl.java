package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        // Just return what was passed (simple logic)
        return campaign;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        // Return an empty Campaign object instead of null
        return new Campaign();
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        // Always return a list, NEVER null
        return new ArrayList<>();
    }
}
