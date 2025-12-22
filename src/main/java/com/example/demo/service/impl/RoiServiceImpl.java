package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiServiceImpl(
            RoiReportRepository roiReportRepository,
            DiscountCodeRepository discountCodeRepository) {

        this.roiReportRepository = roiReportRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport createReport(RoiReport report) {

        DiscountCode code = discountCodeRepository.findById(
                report.getDiscountCode().getId())
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        report.setDiscountCode(code);

        return roiReportRepository.save(report);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
    }
}
