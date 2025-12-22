package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction tx) {
        return ResponseEntity.ok(saleTransactionService.createSale(tx));
    }

    @GetMapping("/{codeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long codeId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCode(codeId));
    }
}
