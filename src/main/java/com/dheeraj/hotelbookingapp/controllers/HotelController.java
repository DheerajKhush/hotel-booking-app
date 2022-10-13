package com.dheeraj.hotelbookingapp.controllers;

import com.dheeraj.hotelbookingapp.dtos.HotelDto;
import com.dheeraj.hotelbookingapp.dtos.HotelFeaturesDto;
import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //add new hotel
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.addHotel(hotelDto), HttpStatus.OK);
    }

    //update hotel details
    @PutMapping
    public ResponseEntity<Hotel> updateHotelDetails(@RequestBody HotelDto hotelDto) {
        if(hotelDto.getId() == null )
            throw new RuntimeException("please provide hotel id to update hotel details");
        return new ResponseEntity<>(hotelService.updateHotelDetails(hotelDto), HttpStatus.OK);
    }

    //Get list of hotels based on city
    @GetMapping("/{city}")
    public ResponseEntity<List<Hotel>> getHotelListByCity(@PathVariable String city) {
        return new ResponseEntity<>(hotelService.getHotelListByCity(city), HttpStatus.OK);
    }

    //Get list of hotels by hotelfeatures
    @PostMapping("/search")
    public ResponseEntity<List<Hotel>> getHotelsBasedOnFeatures(@RequestBody HotelFeaturesDto hotelFeaturesDto){
        return new ResponseEntity<>(hotelService.getHotelByFeatures(hotelFeaturesDto),HttpStatus.OK);
    }



}
