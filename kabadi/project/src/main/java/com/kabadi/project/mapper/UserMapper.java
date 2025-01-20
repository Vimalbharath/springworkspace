package com.kabadi.project.mapper;
import com.kabadi.project.entity.User;
import com.kabadi.project.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}