package com.bitinbyte.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Retrieve bean from Spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
        // Call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        // Call our new methods to get the literal values
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());
        // Close the context
        context.close();

    }

}
