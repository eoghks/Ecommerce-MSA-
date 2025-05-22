package com.example.userService.controller;

import com.example.userService.dto.UserDto;
import com.example.userService.entity.UserEntity;
import com.example.userService.service.UserService;
import com.example.userService.vo.Greeting;
import com.example.userService.vo.RequestUser;
import com.example.userService.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    //private Environment env;
    private Greeting greeting;
    private UserService userService;
    /*
    @Autowired
    public UserController(Environment env) {
        this.env = env;
    }*/
    public UserController(Greeting greeting, UserService userService) {
        this.greeting = greeting;
        this.userService = userService;
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

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser users) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(users, UserDto.class);
        userService.CreateUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
