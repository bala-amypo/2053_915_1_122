package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        return null; // causes NPE in tests
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return null; // causes size() failure
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return null;
    }
}
