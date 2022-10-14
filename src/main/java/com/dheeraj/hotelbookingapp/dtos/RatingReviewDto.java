package com.dheeraj.hotelbookingapp.dtos;

import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.models.User;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
