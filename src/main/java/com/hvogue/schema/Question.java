package com.hvogue.schema;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime; // Time t1
    private LocalDateTime endTime;   // Time when quiz ends
    
    
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getCorrectOption() {
        return correctOption;
    }
    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public void startQuiz() {
        this.startTime = LocalDateTime.now(); // Set t1
        this.endTime = startTime.plusMinutes(10); // Set end time as t1 + 10 minutes
    }

    public boolean isQuizActive() {
        LocalDateTime now = LocalDateTime.now();
        return now.isBefore(endTime) && now.isAfter(startTime);
    }

    // Getters and Setters
}