package com.dheeraj.hotelbookingapp.repositories;

import com.dheeraj.hotelbookingapp.models.RatingReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {
}
