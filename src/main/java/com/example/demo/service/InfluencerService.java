package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Influencer;

@Service
public class InfluencerService {
    private Map<Integer, Influencer> details = new HashMap<>();
    public Influencer addInfluencer(Influencer influencer) {
        details.put(influencer.getId(), influencer);
        return details.get(influencer.getId());
    }

    public List<Influencer> getAllInfluencers() {
        return new ArrayList<>(details.values());
    }
}