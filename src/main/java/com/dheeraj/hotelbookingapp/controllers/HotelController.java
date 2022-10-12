package com.dheeraj.hotelbookingapp.controllers;

import com.dheeraj.hotelbookingapp.dtos.HotelDto;
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
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotelDto){
        return new ResponseEntity<>(hotelService.addHotel(hotelDto), HttpStatus.OK);
    }
    @GetMapping("/{city}")
    public ResponseEntity<List<Hotel>> getHotelListByCity(@PathVariable String city){
        return new ResponseEntity<>(hotelService.getHotelListByCity(city),HttpStatus.OK);
    }

}
