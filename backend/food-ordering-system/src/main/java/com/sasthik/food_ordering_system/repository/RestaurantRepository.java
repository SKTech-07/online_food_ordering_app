package com.sasthik.food_ordering_system.repository;

import com.sasthik.food_ordering_system.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByOwnerId(Long ownerId);

    List<Restaurant> findByNameContainingIgnoreCase(String name);
}