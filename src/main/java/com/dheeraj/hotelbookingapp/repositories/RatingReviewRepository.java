package com.dheeraj.hotelbookingapp.repositories;

import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.models.RatingReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {

    List<RatingReview> findAllByHotel(Hotel hotel);
}
