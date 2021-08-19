package com.bitinbyte.aopdemo;

import java.util.List;

import com.bitinbyte.aopdemo.dao.AccountDAO;
import com.bitinbyte.aopdemo.dao.MembershipDAO;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AfterReturningDemoApp
 */
public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        // Call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();
        // Display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("\n");
        // Close the context
        context.close();
    }
}
