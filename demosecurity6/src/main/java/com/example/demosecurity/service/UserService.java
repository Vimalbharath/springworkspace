package com.example.demosecurity.service; 
import com.example.demosecurity.repository.UserRepository;
import com.example.demosecurity.security.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.example.demosecurity.entity.User;

import com.example.demosecurity.exception.UserNotFoundException;

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

//@RequiredArgsConstructor
//@Service
public interface UserService   { 

//	@Autowired
//	private UserRepository userRepository; 
//
//	@Autowired
//	private PasswordEncoder passwordEncoder; 

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
//
//		Optional<User> userDetail = userRepository.findByUsername(username); 
//
//		// Converting userDetail to UserDetails 
//		return userDetail.map(UserDetailsServiceImpl::new) 
//				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
//	} 
	

//	public String addUser(UserInfo userInfo) { 
//		userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
//		repository.save(userInfo); 
//		return "User Added Successfully"; 
//	} 
	
	
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//   
//    public Optional<User> getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//   
//    public boolean hasUserWithUsername(String username) {
//        return userRepository.existsByUsername(username);
//    }
//
//   
//    public boolean hasUserWithEmail(String email) {
//        return userRepository.existsByEmail(email);
//    }
//
//    
//    public User validateAndGetUserByUsername(String username) {
//        return getUserByUsername(username)
//                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
//    }
//
//    
//    public User saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    
//    public void deleteUser(User user) {
//        userRepository.delete(user);
//    }
//
// 
//    public Optional<User> validUsernameAndPassword(String username, String password) {
//        return getUserByUsername(username)
//                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
//    }
//    public String addUser(User userInfo) { 
//		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword())); 
//		userRepository.save(userInfo); 
//		return "User Added Successfully"; 
//	} 
	List<User> getUsers();

    Optional<User> getUserByUsername(String username);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> validUsernameAndPassword(String username, String password);

} 
