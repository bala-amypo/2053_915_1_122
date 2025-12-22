package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    private SaleTransactionRepository saleRepo;

    @Autowired
    private InfluencerRepository influencerRepo;

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {

        Long influencerId =
                tx.getDiscountCode().getInfluencer().getId();

        Influencer influencer =
                influencerRepo.findById(influencerId)
                        .orElseThrow(() -> new RuntimeException("Influencer not found"));

        tx.getDiscountCode().setInfluencer(influencer);

        return saleRepo.save(tx);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return List.of();
    }
}