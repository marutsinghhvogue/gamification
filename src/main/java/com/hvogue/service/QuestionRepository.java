package com.hvogue.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvogue.schema.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> { }




