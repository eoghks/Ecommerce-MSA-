package com.example.userService.service;

import com.example.userService.dto.UserDto;
import com.example.userService.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    List<UserEntity> getUserByAll();
    UserDto getUserDetailsByEmail(String email);
}
