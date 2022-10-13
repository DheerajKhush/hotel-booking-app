package com.dheeraj.hotelbookingapp.models;

import com.dheeraj.hotelbookingapp.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private Gender gender;
}
