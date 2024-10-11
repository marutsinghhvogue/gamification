package com.hvogue.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvogue.schema.UserResponse;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> { 
    
}
