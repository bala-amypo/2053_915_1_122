package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id,
                                                          @RequestBody DiscountCode c) {
        return ResponseEntity.ok(service.updateDiscountCode(id, c));
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForInfluencer(id));
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForCampaign(id));
    }
}
