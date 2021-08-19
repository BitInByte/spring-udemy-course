package com.bitinbyte.aopdemo.dao;

import com.bitinbyte.aopdemo.Account;

import org.springframework.stereotype.Component;

/**
 * AccountDAO
 */
@Component
public class AccountDAO {
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
