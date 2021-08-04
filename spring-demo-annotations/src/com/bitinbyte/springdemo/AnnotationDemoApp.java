package com.bitinbyte.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AnnotationDemoApp
 */
public class AnnotationDemoApp {
    public static void main(String[] args) {
        // Read Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bean from Spring container
        // Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        // Instead, we use the default bean id
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // Call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // Close the context
        context.close();

    }
}
