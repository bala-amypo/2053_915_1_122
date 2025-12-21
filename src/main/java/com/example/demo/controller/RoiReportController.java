package com.example.demo.controller;

import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoiReportController {

    RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }
}
