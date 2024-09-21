package com.example.demosecurity.security;
import com.example.demosecurity.entity.User;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority; 
import org.springframework.security.core.authority.SimpleGrantedAuthority; 
import org.springframework.security.core.userdetails.UserDetails; 

import java.util.Arrays; 
import java.util.Collection; 
import java.util.List; 
import java.util.stream.Collectors; 
@Data
public class CustomUserDetails implements UserDetails { 

	    private int id;
	    private String username;
	    private String password;
	    private String name;
	    private String email;
	    private Collection<? extends GrantedAuthority> authorities;
	  

//	public CustomUserDetails() {
//			super();
//		}

//	public CustomUserDetails(User userInfo) { 
//		username = userInfo.getUsername(); 
//		password = userInfo.getPassword(); 
//		authorities = Arrays.stream(userInfo.getRole().split(",")) 
//				.map(SimpleGrantedAuthority::new) 
//				.collect(Collectors.toList()); 
//	} 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	@Override
	public String getPassword() { 
		return password; 
	} 

	@Override
	public String getUsername() { 
		return username; 
	} 

	@Override
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isEnabled() { 
		return true; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	

	
} 
