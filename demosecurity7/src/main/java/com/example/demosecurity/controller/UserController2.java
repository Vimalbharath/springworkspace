//package com.example.demosecurity.controller;
//
// 
//import com.example.demosecurity.entity.User;
//import com.example.demosecurity.service.UserService;
//
//
//import org.springframework.beans.factory.annotation.Autowired; 
//import org.springframework.security.access.prepost.PreAuthorize; 
//import org.springframework.security.authentication.AuthenticationManager; 
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
//import org.springframework.security.core.Authentication; 
//import org.springframework.security.core.userdetails.UsernameNotFoundException; 
//import org.springframework.web.bind.annotation.*; 
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/auth") 
//public class UserController2 { 
//
//	@Autowired
//	private UserService service; 
//
//	
//
//	@Autowired
//	private AuthenticationManager authenticationManager; 
//
//	@GetMapping("/welcome") 
//	public String welcome() { 
//		return "Welcome this endpoint is not secure"; 
//	} 
//
//	@PostMapping("/addNewUser") 
//	public User addNewUser(@RequestBody User userInfo) { 
//		return service.saveUser(userInfo); 
//	} 
//
//	@GetMapping("/user/userProfile") 
//	@PreAuthorize("hasAuthority('ROLE_USER')") 
//	public String userProfile() { 
//		return "Welcome to User Profile"; 
//	} 
//
//	@GetMapping("/admin/adminProfile") 
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
//	public String adminProfile() { 
//		return "Welcome to Admin Profile"; 
//	} 
//	
//	 
//
//
//} 
