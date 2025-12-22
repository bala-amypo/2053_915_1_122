package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleTransactionController {
    
    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }
    @PostMapping("/sales")
    public SaleTransaction createSale(@RequestBody SaleTransaction tx) {
        return service.createSale(tx);
    }
    @GetMapping("/code/{id}")
    public List<SaleTransaction> getSalesForCode(@PathVariable Long id) {
        return service.getSalesForCode(id);
    }
}
