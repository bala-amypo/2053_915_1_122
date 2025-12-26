package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository
    ) {
        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {

        // ✅ Hard validation
        if (code.getInfluencer() == null || code.getInfluencer().getId() == null) {
            throw new RuntimeException("Influencer ID is required");
        }

        if (code.getCampaign() == null || code.getCampaign().getId() == null) {
            throw new RuntimeException("Campaign ID is required");
        }

        // ✅ Attach managed entities
        Influencer influencer = influencerRepository.findById(
                code.getInfluencer().getId()
        ).orElseThrow(() ->
                new RuntimeException("Influencer not found")
        );

        Campaign campaign = campaignRepository.findById(
                code.getCampaign().getId()
        ).orElseThrow(() ->
                new RuntimeException("Campaign not found")
        );

        code.setInfluencer(influencer);
        code.setCampaign(campaign);

        return discountCodeRepository.save(code);
    }
}
