package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    // POST – create ROI report (concept)
    @PostMapping
    public RoiReport createReport(@RequestBody RoiReport report) {
        return report;
    }

    // GET – get ROI reports by influencer
    @GetMapping("/{influencerId}")
    public List<RoiReport> getReports(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }

    // PUT – update ROI report
    @PutMapping("/{id}")
    public RoiReport updateReport(
            @PathVariable Long id,
            @RequestBody RoiReport report) {
        return report;
    }
}
