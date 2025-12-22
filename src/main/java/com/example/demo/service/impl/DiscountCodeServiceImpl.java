package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {
        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        Influencer influencer = influencerRepository.findById(
                code.getInfluencer().getId())
                .orElseThrow(() -> new RuntimeException("Influencer not found"));

        Campaign campaign = campaignRepository.findById(
                code.getCampaign().getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        code.setInfluencer(influencer);
        code.setCampaign(campaign);

        return discountCodeRepository.save(code);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        DiscountCode existing = getDiscountCodeById(id);
        existing.setCodeValue(code.getCodeValue());
        existing.setDiscountPercentage(code.getDiscountPercentage());
        return discountCodeRepository.save(existing);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencer_Id(influencerId);
    }

    // 🔥 THIS METHOD WAS MISSING → NOW FIXED
    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaign_Id(campaignId);
    }
}
