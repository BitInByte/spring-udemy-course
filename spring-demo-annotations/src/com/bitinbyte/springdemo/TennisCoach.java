package com.bitinbyte.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    // We don't need constructor or setters, we can
    // do it directly to the field
    // It uses Java Reflection for this
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // Defines a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // @Autowired
    // public TennisCoach(FortuneService theFortuneService) {
    // fortuneService = theFortuneService;
    // }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // Define setter method
    // @Autowired
    // public void setFortuneService(FortuneService theFortuneService) {
    // We can also use a normal method
    // public void doSomeCrazyStuff(FortuneService theFortuneService) {
    // System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
    // fortuneService = theFortuneService;
    // }

}
