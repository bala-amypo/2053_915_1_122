package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }
}
