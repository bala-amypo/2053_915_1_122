package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // ✅ Method signature EXACTLY matches interface
    @Override
    public User getUserByEmail(String email) {
        return new User();
    }
}
