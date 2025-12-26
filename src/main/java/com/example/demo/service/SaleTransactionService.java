package com.example.demo.service;

import com.example.demo.model.SaleTransaction;

import java.util.List;

public interface SaleTransactionService {

    SaleTransaction createSale(Object request);

    List<SaleTransaction> getSalesForCode(Long codeId);

    List<SaleTransaction> getSalesForInfluencer(Long influencerId);

    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
