package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @Operation(
            summary = "Create sale transaction",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SaleTransaction.class)
                    )
            )
    )
    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(
            @org.springframework.web.bind.annotation.RequestBody Object request
    ) {
        return ResponseEntity.ok(service.createSale(request));
    }

    @GetMapping("/discount/{codeId}")
    public ResponseEntity<?> getSalesForCode(@PathVariable Long codeId) {
        return ResponseEntity.ok(service.getSalesForCode(codeId));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<?> getSalesForInfluencer(@PathVariable Long influencerId) {
        return ResponseEntity.ok(service.getSalesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<?> getSalesForCampaign(@PathVariable Long campaignId) {
        return ResponseEntity.ok(service.getSalesForCampaign(campaignId));
    }
}
