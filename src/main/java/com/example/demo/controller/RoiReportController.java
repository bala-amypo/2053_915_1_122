package com.example.demo.controller;

import com.example.demo.service.RoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoiReportController {
    
    private final RoiService service;
    public RoiReportController(RoiService service) {
        this.service = service;
    }
}
