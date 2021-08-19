package com.bitinbyte.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * MembershipDAO
 */
@Component
public class MembershipDAO {
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
