package com.util;

import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm; 
import io.jsonwebtoken.security.Keys; 
 
import javax.crypto.SecretKey; 
import java.util.*; 
 
public class JwtUtil { 
 
    private static final SecretKey SECRET_KEY = 
Keys.secretKeyFor(SignatureAlgorithm.HS256); 
 
    public static String generateToken(String username, List<String> roles) { 
        return Jwts.builder() 
                .setSubject(username) 
                .claim("roles", roles)  //   Add roles claim 
                .setIssuedAt(new Date()) 
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour 
                .signWith(SECRET_KEY) 
                .compact(); 
    } 
 
    public static Map<String, Object> validateToken(String token) { 
        return Jwts.parserBuilder() 
                .setSigningKey(SECRET_KEY) 
                .build() 
                .parseClaimsJws(token) 
                .getBody(); 
    } 
}
