package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode code);

    // 🔥 REQUIRED BY TEST CASES
    DiscountCode getDiscountCodeById(Long id);

    // 🔥 REQUIRED BY TEST CASES
    DiscountCode updateDiscountCode(Long id, DiscountCode code);

    List<DiscountCode> getCodesForInfluencer(Long influencerId);

    List<DiscountCode> getCodesForCampaign(Long campaignId);
}
