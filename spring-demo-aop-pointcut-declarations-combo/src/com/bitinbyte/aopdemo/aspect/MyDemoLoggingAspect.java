package com.bitinbyte.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * MyDemoLoggingAspect
 */
@Aspect
// Discover using component scan
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // Create pointcut for getter methods
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    // Create pointcut for setter methods
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    // Create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
