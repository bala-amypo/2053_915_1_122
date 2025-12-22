package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }

    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(Long id) {
        return ResponseEntity.ok(service.getReportsForInfluencer(id));
    }
}