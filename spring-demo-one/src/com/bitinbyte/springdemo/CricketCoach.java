package com.bitinbyte.springdemo;

/**
 * CricketCoach
 */
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    // Add new fields for emailAddress and team
    private String emailAddress;
    private String team;

    // Create a no-arg constructor
    // Because Spring will call it to construct
    // the object in the object factory
    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor!");
    }



	@Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // Our setter method which will be called by Spring
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService!");
        this.fortuneService = fortuneService;
    }



    public String getEmailAddress() {
        return emailAddress;
    }



    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - setEmailAddress!");
        this.emailAddress = emailAddress;
    }



    public String getTeam() {
        return team;
    }



    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam!");
        this.team = team;
    }

}
