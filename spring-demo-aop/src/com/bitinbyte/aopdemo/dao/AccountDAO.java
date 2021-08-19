package com.bitinbyte.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * AccountDAO
 */
@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
