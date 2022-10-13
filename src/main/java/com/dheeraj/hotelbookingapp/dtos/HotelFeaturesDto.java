package com.dheeraj.hotelbookingapp.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class HotelFeaturesDto {
    @NonNull
    private String city;
    @NonNull
    private Integer noOfVacantRooms;
    private Boolean hasWifi;
    private Boolean hasAC;
    private Boolean provideMeals;
    private Double overallRating;
    private Integer minCostPerNight;
    private Integer maxCostPerNight;
}
