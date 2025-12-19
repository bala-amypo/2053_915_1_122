package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return new DiscountCode();
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        return code;
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return List.of();
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return List.of();
    }
}
