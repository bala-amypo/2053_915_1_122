package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {

    SaleTransaction createSale(Object transaction);

    List<SaleTransaction> getSalesForCode(long discountCodeId);

    List<SaleTransaction> getSalesForInfluencer(long influencerId);

    List<SaleTransaction> getSalesForCampaign(long campaignId);
}
