package com.bitinbyte.aopdemo;

import java.util.logging.Logger;

import com.bitinbyte.aopdemo.service.TrafficFortuneService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AroundDemoApp
 */
public class AroundLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        String data = theFortuneService.getFortune();
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("Finished");
        // Close the context
        context.close();
    }
}
