package com.sasthik.food_ordering_system.repository;

import com.sasthik.food_ordering_system.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRestaurantId(Long restaurantId);

    List<Review> findByUserId(Long userId);

    Optional<Review> findByUserIdAndRestaurantId(Long userId, Long restaurantId);
}