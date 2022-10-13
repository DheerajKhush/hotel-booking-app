package com.dheeraj.hotelbookingapp.controllers;

import com.dheeraj.hotelbookingapp.dtos.UserDto;
import com.dheeraj.hotelbookingapp.models.User;
import com.dheeraj.hotelbookingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //add new hotel
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

}
