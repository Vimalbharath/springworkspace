package com.example.demosecurity.service;

import org.springframework.context.annotation.Bean;


public class BCryptPasswordEncoder {
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
