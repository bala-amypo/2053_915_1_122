package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {
        return tx;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return new ArrayList<>();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return new ArrayList<>();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return new ArrayList<>();
    }
}
