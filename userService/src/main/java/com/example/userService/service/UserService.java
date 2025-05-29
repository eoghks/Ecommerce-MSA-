package com.example.userService.service;

import com.example.userService.dto.UserDto;
import com.example.userService.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserDto CreateUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    List<UserEntity> getUserByAll();
}
