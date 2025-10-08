package com.controller;

import com.util. JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class HelloController {

//Step 1: Generate Token

@PostMapping("/login")

public ResponseEntity<?> login(@RequestParam String username) {
String token = JwtUtil.generateToken(username);

return ResponseEntity.ok("Generated Token: " + token);
}

// Step 2: Validate Token & Return Hello Message

@GetMapping("/hello")

public ResponseEntity<?> hello(@RequestHeader("Authorization")
String token) {

try {
String username = JwtUtil.validateToken(token.replace("Bearer ",""));
return ResponseEntity.ok("Hello, "+ username + "! Your token is valid.");
} catch (Exception e) {
return ResponseEntity.status(401).body("Invalid or expired token!");
}
}
}
