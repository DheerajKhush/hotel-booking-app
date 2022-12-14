package com.dheeraj.hotelbookingapp.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String city;
    private Integer totalNoOfRooms;
    private Integer noOfVacantRooms;
    private Boolean hasWifi;
    private Boolean hasAC;
    private Boolean provideMeals;
    private Integer minCostPerNight;
    private Integer maxCostPerNight;

}
