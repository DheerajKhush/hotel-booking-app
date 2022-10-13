package com.dheeraj.hotelbookingapp.repositories;

import com.dheeraj.hotelbookingapp.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByCity(String city);

    List<Hotel> findAllByCityAndNoOfVacantRoomsGreaterThanEqualAndHasWifiAndHasACAndProvideMeals(String city, Integer noOfVacantRooms, Boolean hasWifi, Boolean hasAC, Boolean ProvideMeals);
    List<Hotel> findAllByCityAndNoOfVacantRoomsGreaterThanEqual(String city, Integer noOfVacantRooms);
    List<Hotel> findAllByCityAndNoOfVacantRoomsGreaterThanEqualOrHasWifiOrHasACOrProvideMeals(String city,Integer noOfVacantRooms, Boolean hasWifi, Boolean hasAC, Boolean ProvideMeals);


}
