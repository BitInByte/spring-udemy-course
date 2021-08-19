package com.bitinbyte.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * MyDemoLoggingAspect
 */
@Aspect
// Discover using component scan
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging
    // Let's start with an @Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
