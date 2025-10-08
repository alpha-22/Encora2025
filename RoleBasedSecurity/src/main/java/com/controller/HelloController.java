package com.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.JwtUtil;

@RestController
public class HelloController {

    @GetMapping("/api/AdminToken")
    public String generateAdminToken() {
        String token = JwtUtil.generateToken("Sam", List.of("ROLE_ADMIN"));
        System.out.println(token);
        return token;
    }

    @GetMapping("/api/UserToken")
    public String generateUserToken() {
        String token = JwtUtil.generateToken("Not-Sam", List.of("ROLE_USER"));
        System.out.println(token);
        return token;
    }

    @GetMapping("/api/hello")
    public String hello(Authentication auth) {
        return "Hello, " + auth.getName() + "! You are authenticated.";
    }

    @GetMapping("/api/admin")
    public String admin(Authentication auth) {
        return "Welcome Admin, " + auth.getName() + "! You have special access.";
    }
}