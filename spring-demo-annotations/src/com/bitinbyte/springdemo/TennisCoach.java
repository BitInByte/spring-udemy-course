package com.bitinbyte.springdemo;

import org.springframework.stereotype.Component;

/**
 * TennisCoach
 */
// Spring will automatically register this bean and
// will use thatSillyCoach as id
// @Component("thatSillyCoach")
// It will use the TennisCoach as tennisCoach as id
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }

}
