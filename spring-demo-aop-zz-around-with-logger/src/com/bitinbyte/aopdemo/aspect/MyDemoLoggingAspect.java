package com.bitinbyte.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import com.bitinbyte.aopdemo.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyDemoLoggingAspect
 */
@Aspect
// Discover using component scan
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.bitinbyte.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        // Print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);
        // Get begin timestamp
        long begin = System.currentTimeMillis();
        // Now, let's execute the method
        Object result = theProceedingJoinPoint.proceed();
        // Get end timestamp
        long end = System.currentTimeMillis();
        // Compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
        return result;

    }

    @After("execution(* com.bitinbyte.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.bitinbyte.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
        // Log the exception
        myLogger.info("\n=====>>> The exception is: " + theExc);

    }

    // Add a new advice for @AferReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.bitinbyte.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
        // Print out the results of the method call
        myLogger.info("\n=====>>> result is: " + result);

        // Let's post-process the data ... let's modify it :-)
        // Convert the account names to uppercase
        convertAccountNamesToUppercase(result);
        myLogger.info("\n=====>>> result is: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        // Loop through accounts
        for (Account tempAccount : result) {
            // Get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            // Update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.bitinbyte.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n=====>>> Executing @Before advice on method");
        // Display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method: " + methodSig);
        // Display method arguments
        // Get args
        Object[] args = theJoinPoint.getArgs();
        // Loop through args
        for (Object tempArg : args) {
            myLogger.info(tempArg.toString());
            if (tempArg instanceof Account) {
                // Downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());
            }
        }
    }

}
