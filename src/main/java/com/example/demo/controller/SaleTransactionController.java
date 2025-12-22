package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    // POST – create sale transaction
    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.createSale(transaction);
    }

    // GET – get sales for discount code
    @GetMapping("/{codeId}")
    public List<SaleTransaction> getSalesForCode(@PathVariable Long codeId) {
        return saleTransactionService.getSalesForCode(codeId);
    }

    // PUT – update sale transaction
    @PutMapping("/{id}")
    public SaleTransaction updateSale(
            @PathVariable Long id,
            @RequestBody SaleTransaction transaction) {
        transaction.setId(id);
        return transaction;
    }
}
