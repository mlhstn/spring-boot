package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricetCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
