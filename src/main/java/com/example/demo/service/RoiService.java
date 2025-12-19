package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface RoiService {
    List<RoiReport> getReportsForInfluencer(Long influencerId);
}
