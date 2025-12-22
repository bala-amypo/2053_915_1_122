package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountCodeController {

    
    private final DiscountCodeService service;
   
    public DiscountCodeController(DiscountCodeService service){
        this.service=service;
    }
    @GetMapping("/codes/{id}")
    public DiscountCode getDiscountCode(@PathVariable Long id) {
        return service.getDiscountCodeById(id);
    }

    @PutMapping("/codes/{id}")
    public DiscountCode updateDiscountCode(@PathVariable Long id,@RequestBody DiscountCode c) {
        return service.updateDiscountCode(id, c);
    }

    @GetMapping("/codes/influencer/{id}")
    public List<DiscountCode> getCodesForInfluencer(@PathVariable Long id) {
        return service.getCodesForInfluencer(id);
    }

    @GetMapping("/codes/campaign/{id}")
    public List<DiscountCode> getCodesForCampaign(@PathVariable Long id) {
        return service.getCodesForCampaign(id);
    }
}
