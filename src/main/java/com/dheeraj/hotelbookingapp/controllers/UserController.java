package com.dheeraj.hotelbookingapp.controllers;

import com.dheeraj.hotelbookingapp.dtos.UserDto;
import com.dheeraj.hotelbookingapp.models.User;
import com.dheeraj.hotelbookingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //add new user
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
