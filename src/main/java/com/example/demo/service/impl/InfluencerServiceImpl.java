package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    private InfluencerRepository repository;

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        return repository.save(influencer); // ✅ SAVED
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return repository.findById(id).orElse(null); // ✅ FETCHED
    }
}
