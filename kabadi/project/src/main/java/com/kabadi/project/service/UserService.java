package com.kabadi.project.service;
import com.kabadi.project.repository.UserRepository;
import com.kabadi.project.security.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.kabadi.project.entity.User;

import com.kabadi.project.exception.UserNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails; 
//import org.springframework.security.core.userdetails.UserDetailsService; 
//import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; 


public interface UserService   { 


	List<User> getUsers();

    Optional<User> getUserByUsername(String username);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> validUsernameAndPassword(String username, String password);

} 
