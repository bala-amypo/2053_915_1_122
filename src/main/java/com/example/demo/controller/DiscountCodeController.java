package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    // POST – create discount code
    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode code) {
        return code;
    }

    // GET – get discount code by id
    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    // PUT – update discount code
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {
        return discountCodeService.updateDiscountCode(id, code);
    }
}
