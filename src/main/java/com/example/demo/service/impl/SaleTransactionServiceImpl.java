package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

@Service
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
    public SaleTransaction createSale(SaleTransaction tx) {

        if (tx.getDiscountCode() != null && tx.getDiscountCode().getId() != null) {

            DiscountCode code = discountRepo.findById(
                    tx.getDiscountCode().getId()
            ).orElseThrow(() -> new RuntimeException("DiscountCode not found"));

            // ✅ Attach FULL entity
            tx.setDiscountCode(code);
        }

        return saleRepo.save(tx);
    }
}
