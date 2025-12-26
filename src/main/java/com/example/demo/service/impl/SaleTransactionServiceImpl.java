package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleRepo;
    private final DiscountCodeRepository discountRepo;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleRepo,
            DiscountCodeRepository discountRepo) {
        this.saleRepo = saleRepo;
        this.discountRepo = discountRepo;
    }

    @Override
    public SaleTransaction createSale(Object transaction) {

        SaleTransaction sale = (SaleTransaction) transaction;

        if (sale.getDiscountCode() == null || sale.getDiscountCode().getId() == null) {
            throw new RuntimeException("DiscountCode is required");
        }

        DiscountCode code = discountRepo.findById(
                sale.getDiscountCode().getId()
        ).orElseThrow(() -> new RuntimeException("DiscountCode not found"));

        sale.setDiscountCode(code);

        return saleRepo.save(sale);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(long discountCodeId) {
        return saleRepo.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(long influencerId) {
        return saleRepo.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(long campaignId) {
        return saleRepo.findByDiscountCodeCampaignId(campaignId);
    }
}
