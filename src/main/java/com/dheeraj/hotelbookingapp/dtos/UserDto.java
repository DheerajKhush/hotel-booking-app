package com.dheeraj.hotelbookingapp.dtos;

import com.dheeraj.hotelbookingapp.enums.Gender;
import lombok.Getter;

@Getter

public class UserDto {
    private String name;
    private Gender gender;
}
