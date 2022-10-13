package com.dheeraj.hotelbookingapp.repositories;

import com.dheeraj.hotelbookingapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
