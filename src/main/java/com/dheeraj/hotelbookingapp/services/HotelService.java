package com.dheeraj.hotelbookingapp.services;

import com.dheeraj.hotelbookingapp.dtos.HotelDto;
import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(HotelDto hotelDto){
        Hotel hotel = new Hotel();
        hotel.setCity(hotelDto.getCity());
        hotel.setName(hotelDto.getName());
        hotel.setTotalNoOfRooms(hotelDto.getTotalNoOfRooms());
        hotel.setNoOfVacantRooms(hotelDto.getNoOfVacantRooms());
        hotel.setHasAC(hotelDto.getHasAC());
        hotel.setHasWifi(hotelDto.getHasWifi());
        hotel.setProvideMeals(hotelDto.getProvideMeals());
        hotel.setMinCostPerNight(hotelDto.getMinCostPerNight());
        hotel.setMaxCostPerNight(hotelDto.getMaxCostPerNight());
        hotelRepository.save(hotel);
        return hotel;
    }

    public List<Hotel> getHotelListByCity(String city) {
        return hotelRepository.findAllByCity(city);

    }
}
