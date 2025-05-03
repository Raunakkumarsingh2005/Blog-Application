package com.spring.blog_app.service;

import com.spring.blog_app.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUsers();
    public UserDto updateUser(UserDto userDto, Long id);
    public void deleteUser(Long id);
}
