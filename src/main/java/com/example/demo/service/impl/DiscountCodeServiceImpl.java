package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.Influencer;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
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

        if (code.getInfluencer() != null && code.getInfluencer().getId() != null) {
            Influencer influencer = influencerRepository
                    .findById(code.getInfluencer().getId())
                    .orElseThrow(() -> new RuntimeException("Influencer not found"));
            code.setInfluencer(influencer);
        }

        if (code.getCampaign() != null && code.getCampaign().getId() != null) {
            Campaign campaign = campaignRepository
                    .findById(code.getCampaign().getId())
                    .orElseThrow(() -> new RuntimeException("Campaign not found"));
            code.setCampaign(campaign);
        }

        return discountCodeRepository.save(code);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DiscountCode not found"));
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
        return discountCodeRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaignId(campaignId);
    }
}
