package com.example.order_service.service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getOrderByUserId(String userId);
    OrderDto getOrderByOrderId(String orderId);
    OrderDto createOrder(OrderDto orderDto);
}
