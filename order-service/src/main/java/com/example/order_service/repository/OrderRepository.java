package com.example.order_service.repository;

import com.example.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(String orderId);
    List<OrderEntity> findByUserId(String userId);
}