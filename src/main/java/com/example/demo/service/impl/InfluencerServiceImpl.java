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
        return influencer;
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return new ArrayList<>();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return new Influencer();
    }
}
