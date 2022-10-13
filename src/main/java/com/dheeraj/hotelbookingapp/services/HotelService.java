package com.dheeraj.hotelbookingapp.services;

import com.dheeraj.hotelbookingapp.dtos.HotelDto;
import com.dheeraj.hotelbookingapp.dtos.HotelFeaturesDto;
import com.dheeraj.hotelbookingapp.exceptions.HotelNotFoundException;
import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.repositories.HotelRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(HotelDto hotelDto) {
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

    public Hotel updateHotelDetails(HotelDto hotelDto) {
        Long id = hotelDto.getId();
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        Hotel hotel;
        if (hotelOptional.isEmpty()) {
            throw new HotelNotFoundException("No matched hotel with id" + id);
        } else {
            hotel = hotelOptional.get();
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
        }
        return hotel;
    }

    public List<Hotel> getHotelByFeatures(HotelFeaturesDto hotelFeaturesDto) {
        return hotelRepository.findAllByCityAndNoOfVacantRoomsGreaterThanEqualAndHasWifiAndHasACAndProvideMeals(hotelFeaturesDto.getCity(), hotelFeaturesDto.getNoOfVacantRooms(), hotelFeaturesDto.getHasWifi(),hotelFeaturesDto.getHasAC(),hotelFeaturesDto.getProvideMeals());
    }
}
