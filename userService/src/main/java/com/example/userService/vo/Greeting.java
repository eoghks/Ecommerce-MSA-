package com.example.userService.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Greeting {
    @Value("${greeting.message}")
    private String message;
}
