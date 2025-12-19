package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(
                service.getDiscountCodeById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id,
                                                          @RequestBody DiscountCode c) {
        return new ResponseEntity<>(
                service.updateDiscountCode(id, c),
                HttpStatus.OK
        );
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getCodesForInfluencer(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getCodesForCampaign(id),
                HttpStatus.OK
        );
    }
}
