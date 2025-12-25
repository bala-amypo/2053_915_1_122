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

    // =========================
    // CREATE
    // =========================
    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.createDiscountCode(code));
    }

    // =========================
    // REQUIRED BY TEST CASES
    // =========================

    // 🔹 TEST CALLS: getDiscountCode(long)
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    // 🔹 TEST CALLS: getCodesForInfluencer(long)
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(
            @PathVariable long influencerId) {
        return ResponseEntity.ok(service.getCodesForInfluencer(influencerId));
    }

    // 🔹 TEST CALLS: getCodesForCampaign(long)
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(
            @PathVariable long campaignId) {
        return ResponseEntity.ok(service.getCodesForCampaign(campaignId));
    }

    // =========================
    // UPDATE (OPTIONAL BUT SAFE)
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.updateDiscountCode(id, code));
    }
}
