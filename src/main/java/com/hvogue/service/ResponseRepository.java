package com.hvogue.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hvogue.schema.UserResponse;

public interface ResponseRepository extends JpaRepository<UserResponse, Long> {
}
