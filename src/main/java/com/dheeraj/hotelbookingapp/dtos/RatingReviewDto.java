package com.dheeraj.hotelbookingapp.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RatingReviewDto {
    @NonNull
    private Long hotel_id;
    @NonNull
    private Long user_id;
    @NonNull
    private Double rating;
    @NonNull
    private String review;
}
