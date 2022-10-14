package com.dheeraj.hotelbookingapp.services;

import com.dheeraj.hotelbookingapp.dtos.UserDto;
import com.dheeraj.hotelbookingapp.models.User;
import com.dheeraj.hotelbookingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return "User not exists";
        } else {
            User user = optionalUser.get();
            userRepository.delete(user);
            return "User deleted successfully";
        }
    }
}
