package com.example.demo.service.impl;

import com.example.demo.entity.Campaign;
import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.Influencer;
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

        discountCodeRepository.findByCode(code.getCode())
                .ifPresent(c -> {
                    throw new RuntimeException("Duplicate discount code");
                });

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
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        DiscountCode existing = getCodeById(id);
        existing.setDiscountPercentage(code.getDiscountPercentage());
        return discountCodeRepository.save(existing);
    }

    @Override
    public DiscountCode getCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Code not found"));
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
        return discountCodeRepository.findAll();
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(Long campaignId) {
        return discountCodeRepository.findAll();
    }

    @Override
    public void deactivateCode(Long id) {
        DiscountCode code = getCodeById(id);
        code.setActive(false);
        discountCodeRepository.save(code);
    }
}
