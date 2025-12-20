package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        return campaign;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return new Campaign();
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return null;
    }
}
