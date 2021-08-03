package com.example.spring_demo_one;

public class MyApp {
    public static void main(String[] args) {
        // Create the object
        Coach theCoach = new BaseballCoach();

        // Use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
