package com.sasthik.food_ordering_system.repository;

import com.sasthik.food_ordering_system.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByRestaurantId(Long restaurantId);

    List<FoodItem> findByRestaurantIdAndAvailabilityTrue(Long restaurantId);

    List<FoodItem> findByCategory(String category);
}