package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountCodeController {
    @Autowired
    DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    public DiscountCode getDiscountCode(Long id) {
        return service.getDiscountCodeById(id);
    }

    public DiscountCode updateDiscountCode(Long id, DiscountCode c) {
        return service.updateDiscountCode(id, c);
    }

    public List<DiscountCode> getCodesForInfluencer(Long id) {
        return service.getCodesForInfluencer(id);
    }

    public List<DiscountCode> getCodesForCampaign(Long id) {
        return service.getCodesForCampaign(id);
    }
}
