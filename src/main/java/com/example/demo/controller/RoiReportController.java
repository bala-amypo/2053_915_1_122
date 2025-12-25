package com.example.demo.controller;

import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }
}
