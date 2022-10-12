package com.dheeraj.hotelbookingapp.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String city;
    private Integer totalNoOfRooms;
    private Integer noOfVacantRooms;
    private Boolean hasWifi;
    private Boolean hasAC;
    private Boolean provideMeals;
    private Integer overallRating;
    private Integer minCostPerNight;
    private Integer maxCostPerNight;
}
