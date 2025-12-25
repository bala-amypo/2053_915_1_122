package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repo;

    public DiscountCodeServiceImpl(DiscountCodeRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        code.setId(id);
        return repo.save(code);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return repo.findAll();
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return repo.findAll();
    }
}
