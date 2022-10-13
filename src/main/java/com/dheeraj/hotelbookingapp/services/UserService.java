package com.dheeraj.hotelbookingapp.services;

import com.dheeraj.hotelbookingapp.dtos.UserDto;
import com.dheeraj.hotelbookingapp.models.User;
import com.dheeraj.hotelbookingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        return userRepository.save(user);
    }

}
