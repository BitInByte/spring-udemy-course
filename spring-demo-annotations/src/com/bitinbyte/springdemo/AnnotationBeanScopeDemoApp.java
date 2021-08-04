package com.bitinbyte.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AnnotationBeanScopeDemoApp
 */
public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        // Load Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve Bean from Spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // Check if they are the same
        boolean result = (theCoach == alphaCoach);

        // Print out the results
        System.out.println("\nPointing to the same object? " + result);
        System.out.println("\nMemory Location for theCoach: " + theCoach);
        System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");

        // Close the context
        context.close();

    }
}
