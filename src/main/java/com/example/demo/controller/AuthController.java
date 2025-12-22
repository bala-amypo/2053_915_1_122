package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class AuthController {

    
    private final UserService userService;
    public AuthController(UserService userService){
        this.userService=userService;
    }
}
