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
    // @Before("execution(public void addAccount())")
    // @Before("execution(public void updateAccount())")
    // @Before("execution(public void
    // com.bitinbyte.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* add*(com.bitinbyte.aopdemo.Account))")
    // @Before("execution(* add*(Account))")
    // @Before("execution(* add*(com.bitinbyte.aopdemo.Account, ..))")
    // @Before("execution(* add*(..))")
    @Before("execution(* com.bitinbyte.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        // System.out.println("\n=====>>> Executing @Before advice on addAccount()");
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}
