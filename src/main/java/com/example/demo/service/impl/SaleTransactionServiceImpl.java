package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SaleTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    private SaleTransactionRepository saleRepo;

    @Autowired
    private InfluencerRepository influencerRepo;

    @Autowired
    private CampaignRepository campaignRepo;

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {

        Long influencerId =
                tx.getDiscountCode().getInfluencer().getId();

        Influencer influencer = influencerRepo.findById(influencerId)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));

        tx.getDiscountCode().setInfluencer(influencer);

        return saleRepo.save(tx);
    }
}