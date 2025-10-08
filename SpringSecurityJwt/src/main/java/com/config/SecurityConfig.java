package com.config;

import com.security.JwtFilter; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import 
org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import 
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.http.SessionCreationPolicy; 
import org.springframework.security.web.SecurityFilterChain; 
import 
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 
 
@Configuration 
@EnableWebSecurity 
public class SecurityConfig { 
 
    private final JwtFilter jwtFilter; 
 
    public SecurityConfig(JwtFilter jwtFilter) { 
        this.jwtFilter = jwtFilter; 
    } 
 
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws 
Exception { 
        return http.csrf(csrf -> csrf.disable()) 
                .authorizeHttpRequests(auth -> auth 
                        .requestMatchers("/api/login").permitAll()  // Allow token generation without auth 
                        .anyRequest().authenticated()              // Everything else requires token 
                ) 
                .sessionManagement(sm -> 
sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
                .addFilterBefore(jwtFilter, 
UsernamePasswordAuthenticationFilter.class) 
                .build(); 
    } 
}