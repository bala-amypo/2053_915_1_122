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

        // ✅ Fetch Influencer fully
        if (code.getInfluencer() != null && code.getInfluencer().getId() != null) {
            Influencer influencer = influencerRepository
                    .findById(code.getInfluencer().getId())
                    .orElseThrow(() -> new RuntimeException("Influencer not found"));
            code.setInfluencer(influencer);
        }

        // ✅ Fetch Campaign fully
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
        return discountCodeRepository.findById(id).orElse(null);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        code.setId(id);
        return discountCodeRepository.save(code);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long id) {
        return discountCodeRepository.findByInfluencerId(id);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long id) {
        return discountCodeRepository.findByCampaignId(id);
    }
}
