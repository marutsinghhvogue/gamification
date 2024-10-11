package com.hvogue.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvogue.schema.Winner;

public interface WinnerRepository extends JpaRepository<Winner, Long> {
    Optional<Winner> findByQuestionId(Long questionId);
}
