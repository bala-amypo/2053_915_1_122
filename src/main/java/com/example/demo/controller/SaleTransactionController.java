package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(
            @RequestBody SaleTransaction transaction) {
        return ResponseEntity.ok(service.createSaleTransaction(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleTransaction> getSale(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSaleTransactionById(id));
    }

    @GetMapping("/discount-code/{discountCodeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesByDiscountCode(
            @PathVariable Long discountCodeId) {
        return ResponseEntity.ok(service.getSalesByDiscountCode(discountCodeId));
    }
}
