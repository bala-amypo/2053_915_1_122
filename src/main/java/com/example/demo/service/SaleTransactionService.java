package com.example.demo.service;

import com.example.demo.model.SaleTransaction;

import java.util.List;

public interface SaleTransactionService {

    SaleTransaction createSaleTransaction(SaleTransaction transaction);

    SaleTransaction getSaleTransactionById(Long id);

    List<SaleTransaction> getSalesByDiscountCode(Long discountCodeId);
}
