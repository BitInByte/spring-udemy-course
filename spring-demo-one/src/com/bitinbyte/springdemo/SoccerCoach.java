package com.bitinbyte.springdemo;

public class SoccerCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 2 hours on kicking a ball!";
    }
}
