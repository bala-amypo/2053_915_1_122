package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    // ✅ CREATE discount code
    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.createDiscountCode(code));
    }

    // ✅ GET discount code by ID
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCodeById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    // ✅ UPDATE discount code
    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.updateDiscountCode(id, code));
    }

    // ✅ GET all discount codes for an influencer
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> getCodesByInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(service.getCodesForInfluencer(influencerId));
    }

    // ✅ GET all discount codes for a campaign
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> getCodesByCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(service.getCodesForCampaign(campaignId));
    }
}
