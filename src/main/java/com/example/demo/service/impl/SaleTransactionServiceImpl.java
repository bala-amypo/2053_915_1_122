package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleRepo;
    private final DiscountCodeRepository discountRepo;
    private final ObjectMapper objectMapper;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleRepo,
            DiscountCodeRepository discountRepo,
            ObjectMapper objectMapper
    ) {
        this.saleRepo = saleRepo;
        this.discountRepo = discountRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public SaleTransaction createSale(Object request) {

        SaleTransaction sale =
                objectMapper.convertValue(request, SaleTransaction.class);

        if (sale.getDiscountCode() != null && sale.getDiscountCode().getId() != null) {
            DiscountCode code = discountRepo.findById(
                    sale.getDiscountCode().getId()
            ).orElseThrow(() -> new RuntimeException("Discount code not found"));

            sale.setDiscountCode(code);
        }

        return saleRepo.save(sale);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return saleRepo.findByDiscountCodeId(codeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleRepo.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleRepo.findByDiscountCodeCampaignId(campaignId);
    }
}
