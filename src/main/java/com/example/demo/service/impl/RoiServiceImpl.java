package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        // NEVER return null for a List
        return new ArrayList<>();
    }
}
