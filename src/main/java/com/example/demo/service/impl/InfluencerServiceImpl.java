package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repo;

    public InfluencerServiceImpl(InfluencerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        return repo.save(influencer);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return repo.findAll();
    }
}
