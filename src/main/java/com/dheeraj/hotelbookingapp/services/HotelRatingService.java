package com.dheeraj.hotelbookingapp.services;

import com.dheeraj.hotelbookingapp.dtos.RatingReviewDto;
import com.dheeraj.hotelbookingapp.exceptions.HotelNotFoundException;
import com.dheeraj.hotelbookingapp.exceptions.UserNotFoundException;
import com.dheeraj.hotelbookingapp.models.Hotel;
import com.dheeraj.hotelbookingapp.models.RatingReview;
import com.dheeraj.hotelbookingapp.models.User;
import com.dheeraj.hotelbookingapp.repositories.HotelRepository;
import com.dheeraj.hotelbookingapp.repositories.RatingReviewRepository;
import com.dheeraj.hotelbookingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelRatingService {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingReview addRating(RatingReviewDto ratingReviewDto) {
        RatingReview ratingReview = new RatingReview();
        Optional<User> userOptional = userRepository.findById(ratingReviewDto.getUser_id());
        if (userOptional.isEmpty())
            throw new UserNotFoundException("User not found, please check provided userId");
        else {
            ratingReview.setUser(userOptional.get());
            Optional<Hotel> hotelOptional = hotelRepository.findById(ratingReviewDto.getHotel_id());
            if (hotelOptional.isEmpty())
                throw new HotelNotFoundException("Hotel not found, please check provided hotelId");
            ratingReview.setHotel(hotelOptional.get());
            ratingReview.setRating(ratingReviewDto.getRating());
            ratingReview.setReview(ratingReview.getReview());
            ratingReviewRepository.save(ratingReview);
            updateHotelOverallRating(hotelOptional.get());
        }
        return ratingReview;
    }

    private void updateHotelOverallRating(Hotel hotel) {
        List<RatingReview> ratingReviewList = ratingReviewRepository.findAllByHotel(hotel);
        Double averageRating = ratingReviewList.stream().collect(Collectors.averagingDouble(RatingReview::getRating));
        hotel.setOverallRating(averageRating);
        hotelRepository.save(hotel);
    }


}
