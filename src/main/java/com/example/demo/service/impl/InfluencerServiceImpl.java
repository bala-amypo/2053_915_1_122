package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        // Safe: returning non-null object
        return influencer;
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        // NEVER return null
        return new ArrayList<>();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        // Safe non-null object
        return new Influencer();
    }
}
