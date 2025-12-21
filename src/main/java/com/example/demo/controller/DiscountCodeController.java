package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountCodeController {

    DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    public ResponseEntity<DiscountCode> getDiscountCode(Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<DiscountCode> updateDiscountCode(Long id, DiscountCode c) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
