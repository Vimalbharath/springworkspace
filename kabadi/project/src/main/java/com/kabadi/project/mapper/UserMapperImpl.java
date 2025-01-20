package com.kabadi.project.mapper;
import org.springframework.stereotype.Service;

import com.kabadi.project.entity.User;
import com.kabadi.project.rest.dto.UserDto;

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
