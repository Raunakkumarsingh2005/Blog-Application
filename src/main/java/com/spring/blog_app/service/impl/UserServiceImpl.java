package com.spring.blog_app.service.impl;

import com.spring.blog_app.dto.UserDto;
import com.spring.blog_app.entity.Users;
import com.spring.blog_app.mapper.UserMapper;
import com.spring.blog_app.repository.UserRepository;
import com.spring.blog_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = userMapper.toEntity(userDto);
        user.setCreatedAt(new Date());
        userRepository.save(user);
        return userMapper.toDto(userRepository.findById(user.getId()).orElseThrow());
    }

    @Override
    public UserDto getUserById(Long id) {
        Users user = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (Users u : users) {
            userDtos.add(userMapper.toDto(u));
        }
        return userDtos;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        Users existingUser = userRepository.findById(id).orElseThrow();
        Optional.ofNullable(userDto.getName()).ifPresent(existingUser::setName);
        Optional.ofNullable(userDto.getEmail()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(userDto.getAbout()).ifPresent(existingUser::setAbout);
        Optional.ofNullable(userDto.getPassword()).ifPresent(existingUser::setPassword);


//        existingUser.setEmail(userDto.getEmail());
//        existingUser.setAbout(userDto.getAbout());
        existingUser.setUpdatedAt(new Date());
//        existingUser.setPassword(userDto.getPassword());
        userRepository.save(existingUser);

        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }
}
