package com.example.userService.vo;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super(String.format("User with ID [%s] not found.", userId));
    }
}