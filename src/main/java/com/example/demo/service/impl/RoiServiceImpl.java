package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository repo;

    public RoiServiceImpl(RoiReportRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return repo.findAll();
    }
}
