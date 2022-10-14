package com.dheeraj.hotelbookingapp.controllers;

import com.dheeraj.hotelbookingapp.dtos.HotelDto;
import com.dheeraj.hotelbookingapp.dtos.HotelFeaturesDto;
import com.dheeraj.hotelbookingapp.dtos.RatingReviewDto;
import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.models.RatingReview;
import com.dheeraj.hotelbookingapp.services.HotelRatingService;
import com.dheeraj.hotelbookingapp.services.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRatingService hotelRatingService;

    @Operation(summary = "add new hotel")
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.addHotel(hotelDto), HttpStatus.OK);
    }

    @Operation(summary = "update hotel details")
    @PutMapping
    public ResponseEntity<Hotel> updateHotelDetails(@RequestBody HotelDto hotelDto) {
        if (hotelDto.getId() == null)
            throw new RuntimeException("please provide hotel id to update hotel details");
        return new ResponseEntity<>(hotelService.updateHotelDetails(hotelDto), HttpStatus.OK);
    }

    @Operation(summary = "Get list of hotels based on city")
    @GetMapping
    public ResponseEntity<List<Hotel>> getHotelListByCity(@RequestParam(name = "city") String city) {
        return new ResponseEntity<>(hotelService.getHotelListByCity(city), HttpStatus.OK);
    }

    @Operation(summary = "Get list of hotels by hotel features")
    @PostMapping("/search")
    public ResponseEntity<List<Hotel>> getHotelsBasedOnFeatures(@RequestBody HotelFeaturesDto hotelFeaturesDto) {
        return new ResponseEntity<>(hotelService.getHotelByFeatures(hotelFeaturesDto), HttpStatus.OK);
    }

    @Operation(summary = "Add rating & review to hotel")
    @PostMapping("/review")
    public ResponseEntity<RatingReview> addRatingReview(@RequestBody RatingReviewDto ratingReviewDto) {
        return new ResponseEntity<>(hotelRatingService.addRating(ratingReviewDto), HttpStatus.OK);
    }

}
