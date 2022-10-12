package com.dheeraj.hotelbookingapp.repositories;

import com.dheeraj.hotelbookingapp.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    List<Hotel> findAllByCity(String city);
}
