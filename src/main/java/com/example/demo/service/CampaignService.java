package com.example.demo.service;

import com.example.demo.model.Campaign;
import java.util.List;

public interface CampaignService {

    Campaign createCampaign(Campaign campaign);

    Campaign getCampaignById(Long id);

    Campaign updateCampaign(Long id, Campaign campaign);

    List<Campaign> getAllCampaigns();
}
