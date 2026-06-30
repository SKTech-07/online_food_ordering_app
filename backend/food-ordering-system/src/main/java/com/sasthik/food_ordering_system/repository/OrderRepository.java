package com.sasthik.food_ordering_system.repository;

import com.sasthik.food_ordering_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

    List<Order> findByRestaurantId(Long restaurantId);

    List<Order> findByStatus(Order.OrderStatus status);

    List<Order> findByUserIdOrderByOrderDateDesc(Long userId);
}