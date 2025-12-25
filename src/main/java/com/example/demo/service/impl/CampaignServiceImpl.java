package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository repo;

    public CampaignServiceImpl(CampaignRepository repo) {
        this.repo = repo;
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        campaign.setId(id);
        return repo.save(campaign);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return repo.findAll();
    }
}
