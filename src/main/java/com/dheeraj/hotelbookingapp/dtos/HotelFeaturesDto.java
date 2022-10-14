package com.dheeraj.hotelbookingapp.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class HotelFeaturesDto {
    @NonNull
    private String city;
    @NonNull
    private Integer noOfVacantRooms;
    private Boolean hasWifi = false;
    private Boolean hasAC = false;
    private Boolean provideMeals = false;
    private Double overallRating = 0.0;
    private Integer minCostPerNight = 0;
    private Integer maxCostPerNight = 0;
}
