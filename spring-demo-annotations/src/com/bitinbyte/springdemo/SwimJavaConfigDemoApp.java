package com.bitinbyte.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * JavaConfigDemoApp
 */
public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // Read Spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // Get the bean from Spring container
        // Coach theCoach = context.getBean("swimCoach", Coach.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // Call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // Call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // Call our new swim coach methods ...has the props values injected
        System.out.println("Email: " + theCoach.getEmail());
        System.out.println("Team: " + theCoach.getTeam());

        // Close the context
        context.close();

    }
}
