package com.example.demosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demosecurity.entity.User;
import com.example.demosecurity.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user)  {
         // Implement validation logic
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password
        user.setRole("NORMAL_USER"); // Set default role to "NORMAL_USER"
        User savedUser = userRepository.save(user);
        return savedUser;
    }

   
}