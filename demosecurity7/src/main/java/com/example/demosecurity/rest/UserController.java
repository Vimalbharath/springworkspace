package com.example.demosecurity.rest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosecurity.entity.User;
import com.example.demosecurity.mapper.UserMapper;
import com.example.demosecurity.rest.dto.UserDto;
import com.example.demosecurity.security.CustomUserDetails;
import com.example.demosecurity.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


import static com.example.demosecurity.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
    private  UserService userService;
	@Autowired
    private  UserMapper userMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/me")
    public UserDto getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return userMapper.toUserDto(userService.validateAndGetUserByUsername(currentUser.getUsername()));
    }
//    @Operation
//    @GetMapping("/me")
//    public UserDto getCurrentUser( CustomUserDetails currentUser) {
//        return userMapper.toUserDto(userService.validateAndGetUserByUsername(currentUser.getUsername()));
//    }
    @GetMapping("/admin") 
	@PreAuthorize("hasAuthority('ADMIN')") 
	public String adminProfile() { 
		return "Welcome to Admin Profile"; 
	} 

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userMapper.toUserDto(userService.validateAndGetUserByUsername(username));
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{username}")
    public UserDto deleteUser(@PathVariable String username) {
        User user = userService.validateAndGetUserByUsername(username);
        userService.deleteUser(user);
        return userMapper.toUserDto(user);
    }
}