package com.dheeraj.hotelbookingapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rating_review")
@Getter
@Setter
public class RatingReview {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private Double rating;
    private String review;

    private Date creationTime;
}
