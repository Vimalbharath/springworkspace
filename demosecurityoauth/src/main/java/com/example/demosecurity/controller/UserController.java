package com.example.demosecurity.controller;


import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*; 

@RestController
public class UserController { 
	@GetMapping("/user")
	public Map<String,Object> getUser(@AuthenticationPrincipal OAuth2User oAuth2User){
		return oAuth2User.getAttributes();
	}
	@GetMapping("/welcome") 
	public String welcome() { 
		return "Welcome this endpoint is secured with oAuth"; 
	} 

} 
