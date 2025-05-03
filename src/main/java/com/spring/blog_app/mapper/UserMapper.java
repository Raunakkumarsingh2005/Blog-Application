package com.spring.blog_app.mapper;

import com.spring.blog_app.dto.UserDto;
import com.spring.blog_app.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(Users user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getAbout());
    }

    // Convert UserDto to Users entity (if you need it for update operations)
    public Users toEntity(UserDto userDto) {
        Users user = new Users();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
