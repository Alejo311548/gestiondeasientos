package com.aerolinea.gestiondeasientos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS
                .and()
                .csrf().disable() // Disable CSRF protection (use cautiously)
                .authorizeHttpRequests()
                .requestMatchers("/api/asientos/**").permitAll() // Allow public access to seat management
                .requestMatchers("/api/reservas/**").permitAll() // Allow public access to reservation management
                .requestMatchers(HttpMethod.PUT, "/api/reservas/**").permitAll()

                .anyRequest().authenticated(); // Require authentication for other requests

        return http.build();
    }
}
