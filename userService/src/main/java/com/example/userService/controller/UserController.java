package com.example.userService.controller;

import com.example.userService.vo.Greeting;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    //private Environment env;
    private Greeting greeting;

    /*
    @Autowired
    public UserController(Environment env) {
        this.env = env;
    }*/
    public UserController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/health_check")
    public String healthCheck(){
        return "User Service is Working";
    }
    @GetMapping("/welcome")
    public String welcome(){
        //return env.getProperty("greeting.message");
        return greeting.getMessage();
    }
}
