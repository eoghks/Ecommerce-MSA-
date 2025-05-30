package com.example.order_service.controller;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.service.OrderService;
import com.example.order_service.vo.RequestOrder;
import com.example.order_service.vo.ResponseOrder;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class orderController {
    Environment env;
    OrderService orderService;

    public orderController(OrderService orderService, Environment env) {
        this.orderService = orderService;
        this.env = env;
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@RequestBody RequestOrder order,
                                                     @PathVariable("userId") String userId) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDto orderDto = mapper.map(order, OrderDto.class);
        orderDto.setUserId(userId);
        OrderDto newOrderDto = orderService.createOrder(orderDto);

        ResponseOrder responseUser = mapper.map(newOrderDto, ResponseOrder.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrderByUserId(@PathVariable("userId") String userId){
        List<OrderEntity> orders = orderService.getOrderByUserId(userId);
        List<ResponseOrder> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        orders.forEach(u->{
            result.add(mapper.map(u, ResponseOrder.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/health_check")
    public String healthCheck(){
        return String.format("Order Service is Working on PORT %s", env.getProperty("local.server.port"));
    }
}
