package com.example.first_service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
    Environment env;

    public FirstServiceController(Environment env) {
        this.env =env;
    }

    @GetMapping("/welcome")
    public String welcom(){
        return "Welcom to the First service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "Hello First Service: Message";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server pot={}", request.getServerPort());
        return String.format("Check First Service on PORT %s", env.getProperty("local.server.port"));
    }
}
