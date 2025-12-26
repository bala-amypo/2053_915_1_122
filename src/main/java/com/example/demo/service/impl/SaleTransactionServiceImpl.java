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
    public SaleTransaction createSaleTransaction(SaleTransaction transaction) {

        if (transaction.getDiscountCode() == null ||
            transaction.getDiscountCode().getId() == null) {
            throw new RuntimeException("Discount code is required");
        }

        DiscountCode code = discountRepo.findById(
                transaction.getDiscountCode().getId()
        ).orElseThrow(() -> new RuntimeException("DiscountCode not found"));

        transaction.setDiscountCode(code);

        return saleRepo.save(transaction);
    }

    @Override
    public SaleTransaction getSaleTransactionById(Long id) {
        return saleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SaleTransaction not found"));
    }

    @Override
    public List<SaleTransaction> getSalesByDiscountCode(Long discountCodeId) {
        return saleRepo.findByDiscountCodeId(discountCodeId);
    }
}
