package com.example.demosecurity.mapper;

import org.springframework.stereotype.Service;

import com.example.demosecurity.entity.User;
import com.example.demosecurity.rest.dto.UserDto;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getUsername(),  user.getName(),user.getEmail(), user.getRole());
    }
}
