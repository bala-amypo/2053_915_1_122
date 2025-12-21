package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleTransactionController {

    SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction tx) {
        return service.createSale(tx);
    }

    @GetMapping("/code/{id}")
    public List<SaleTransaction> getSalesForCode(@PathVariable Long id) {
        return service.getSalesForCode(id);
    }
}
