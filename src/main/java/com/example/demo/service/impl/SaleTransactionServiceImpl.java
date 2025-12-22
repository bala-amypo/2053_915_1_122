package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    private SaleTransactionRepository saleRepo;

    @Autowired
    private InfluencerRepository influencerRepo;

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {

        // Step 1: Get influencer ID from request
        Long influencerId =
            tx.getDiscountCode().getInfluencer().getId();

        // Step 2: Fetch influencer from DB
        Influencer influencer =
            influencerRepo.findById(influencerId)
            .orElseThrow(() -> new RuntimeException("Influencer not found"));

        // Step 3: Set full influencer object
        tx.getDiscountCode().setInfluencer(influencer);

        // Step 4: Save transaction
        return saleRepo.save(tx);
    }
}