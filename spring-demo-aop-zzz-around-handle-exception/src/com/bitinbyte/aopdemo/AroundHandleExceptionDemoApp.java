package com.bitinbyte.aopdemo;

import java.util.logging.Logger;

import com.bitinbyte.aopdemo.service.TrafficFortuneService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AroundHandleExceptionDemoApp
 */
public class AroundHandleExceptionDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("Finished");
        // Close the context
        context.close();
    }
}
