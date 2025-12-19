package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction tx) {
        return ResponseEntity.ok(service.createSale(tx));
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSalesForCode(id));
    }
}
