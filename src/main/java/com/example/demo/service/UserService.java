package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface UserService {
    User findByEmail(String email);
}
