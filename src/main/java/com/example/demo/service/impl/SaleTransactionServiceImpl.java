package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {

        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {
        tx.setDiscountCode(
                discountCodeRepository.findById(tx.getDiscountCode().getId())
                        .orElseThrow(() -> new RuntimeException("Discount code not found"))
        );
        return saleTransactionRepository.save(tx);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return saleTransactionRepository.findByDiscountCode_Id(codeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCode_Campaign_Id(campaignId);
    }
}
