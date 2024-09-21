package com.example.demosecurity.mapper;

import com.example.demosecurity.entity.User;
import com.example.demosecurity.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}