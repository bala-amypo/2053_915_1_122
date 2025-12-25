package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repo;

    public SaleTransactionServiceImpl(SaleTransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {
        return repo.save(tx);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return repo.findAll();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return repo.findAll();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return repo.findAll();
    }
}
